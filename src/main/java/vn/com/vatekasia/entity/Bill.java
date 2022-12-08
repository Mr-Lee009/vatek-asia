package vn.com.vatekasia.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bill")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bill extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "time_payment")
    private LocalDateTime timePayment;
    @Column(name = "total_price")
    private double totalPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private EUser user;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bill")
    private List<BookingRoom> bookingRooms;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "voucher_used_bill",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "voucher_id"))
    private List<Voucher> vouchers;

}

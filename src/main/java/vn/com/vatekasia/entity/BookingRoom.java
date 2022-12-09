package vn.com.vatekasia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vatekasia.enumeration.ERoomStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "booking_room")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingRoom extends BaseEntity {
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "start_time_use")
    private LocalDateTime startTimeUse;
    @Column(name = "end_time_use")
    private LocalDateTime endTimeUse;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private EUser user;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "combo_id")
    private Combo combo;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookingRoom")
    private List<Customer> customers;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookingRoom")
    private List<BookingService> bookingServices;
}

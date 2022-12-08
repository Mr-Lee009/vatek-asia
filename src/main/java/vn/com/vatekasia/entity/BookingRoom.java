package vn.com.vatekasia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookingRoom")
    private List<Customer> customers;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookingRoom")
    private List<BookingService> bookingServices;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "combo_in_booking_room",
            joinColumns = @JoinColumn(name = "booking_room_id"),
            inverseJoinColumns = @JoinColumn(name = "combo_id"))
    private List<Combo> combos;
}

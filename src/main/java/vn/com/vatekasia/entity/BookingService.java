package vn.com.vatekasia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "booking_service")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingService extends BaseEntity {
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "total_price")
    private double totalPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Service service;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_room_id")
    private BookingRoom bookingRoom;
}

package vn.com.vatekasia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vatekasia.enumeration.EPersonType;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {
    @Column(name = "cmt")
    private String cmt;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private EPersonType personType;
    @Column(name = "age")
    private int age;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_booking_room")
    private BookingRoom bookingRoom;
}

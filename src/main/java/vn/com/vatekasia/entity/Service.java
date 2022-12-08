package vn.com.vatekasia.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "service")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Service extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
}

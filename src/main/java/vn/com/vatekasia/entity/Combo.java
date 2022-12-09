package vn.com.vatekasia.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vatekasia.enumeration.EDiscountType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "combo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Combo extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "discount_amount")
    private double discountAmount;
    @Column(name = "discount_type")
    @Enumerated(EnumType.STRING)
    private EDiscountType discountType;
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "description")
    private String description;
    @Column(name = "expired_date")
    private LocalDateTime expiredDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
}

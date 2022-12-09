package vn.com.vatekasia.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vatekasia.enumeration.EDiscountType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "voucher")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Voucher extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "discount_amount")
    private String discountAmount;
    @Column(name = "discount_type")
    @Enumerated(EnumType.STRING)
    private EDiscountType discountType;
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "description")
    private String description;
    @Column(name = "expired_date")
    private LocalDateTime expiredDate;
}

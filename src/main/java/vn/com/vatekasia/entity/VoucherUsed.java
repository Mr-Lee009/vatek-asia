package vn.com.vatekasia.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.vatekasia.enumeration.EVoucherStatus;

import javax.persistence.*;

@Entity
@Table(name = "voucher_used")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoucherUsed extends BaseEntity{
    private EVoucherStatus status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private EUser user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
}

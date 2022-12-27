package vn.com.vatekasia.util;

import lombok.Data;
import vn.com.vatekasia.entity.Bill;
import vn.com.vatekasia.entity.Coupon;

import java.util.List;

@Data
public class ListCoupon {
    private List<Coupon> listCoupon;
    private int totalPage;
    private int size;
    private int page;
}

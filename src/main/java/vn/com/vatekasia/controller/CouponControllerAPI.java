package vn.com.vatekasia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import vn.com.vatekasia.dto.ListCoupon;
import vn.com.vatekasia.entity.Coupon;
import vn.com.vatekasia.entity.User;
import vn.com.vatekasia.repository.CouponRepository;
import vn.com.vatekasia.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping(",api/coupon")
public class CouponControllerAPI {
    @Autowired
    CouponRepository couponRepo;

    @Autowired
    UserRepository userRepo;

    @PostMapping("/create")
    public Coupon create(@RequestBody Coupon coupon) {
        List<User> users = userRepo.findAll();
        couponRepo.save(coupon);
        return coupon;

    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(value = "id") Long id) {
        couponRepo.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Coupon coupon ) {
        Coupon coupons = couponRepo.getById(coupon.getId());
        List<User> users = userRepo.findAll();
        ;

        coupons.setName(coupon.getName());
        couponRepo.save(coupons);
    }

    @PostMapping("/search")
    public ListCoupon search(@RequestParam(name = "name", required = false) String name,
                             @RequestParam(name = "id", required = false) Long id,
                             @RequestParam(name = "sortBy", required = false) Integer sortBy,
                             @RequestParam(name = "page", required = false) Integer page,
                             @RequestParam(name = "size", required = false) Integer size) {

        if (size == null)
            size = 3;// max records per page
        if (page == null)
            page = 0;// trang hien tai
        Sort sort = Sort.by("id").ascending();
        if (sortBy != null && sortBy.equals("name")) {
            sort = Sort.by("name").ascending();
        }

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Coupon> pageCoupon = null;
        if (name != null && !name.isEmpty()) {
            pageCoupon = couponRepo.searchAll("%" + name + "%", pageable);

        } else {
            pageCoupon = couponRepo.findAll(pageable);
        }
        ListCoupon listCoupon = new ListCoupon();
        listCoupon.setListCoupon(pageCoupon.toList());
        listCoupon.setTotalPage(pageCoupon.getTotalPages());
        listCoupon.setSize(size);
        listCoupon.setPage(page);

        return listCoupon;
    }
}

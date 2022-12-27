package vn.com.vatekasia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.vatekasia.entity.Coupon;
@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findByCouponCode(String s);
    @Query("SELECT u FROM Coupon u WHERE u.name LIKE :x")
    Page<Coupon> searchAll(@Param("x") String s, Pageable pageable);
    @Query("SELECT u FROM Coupon u JOIN u.user c " + "WHERE c.id = :cId")
    Page<Coupon> searchByUser(@Param("cId") Long userId, Pageable pageable);
}

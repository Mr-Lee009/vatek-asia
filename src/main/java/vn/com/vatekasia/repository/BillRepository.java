package vn.com.vatekasia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.com.vatekasia.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
	@Query("SELECT u FROM Bill u WHERE u.name LIKE :x")
	Page<Bill> searchAll(@Param("x") String s, Pageable pageable);

}

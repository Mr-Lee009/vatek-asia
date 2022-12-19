package vn.com.vatekasia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.vatekasia.entity.Customer;

@Repository
public interface CustomerReponsitory extends JpaRepository<Customer, Long> {
	@Query("SELECT u FROM Customer u WHERE u.name LIKE :x")
	Page<Customer> searchAll(@Param("x") String s, Pageable pageable);

	@Query("SELECT u FROM Customer u WHERE u.id = uId ")
	Page<Customer> searchById(@Param("uId") Long id, Pageable pageable);
}

package vn.com.vatekasia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import vn.com.vatekasia.entity.Bill;
@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
//	@Query("SELECT u FROM Bill u WHERE u.name LIKE :x")
//	Page<Bill> searchAll(@Param("x") String s, Pageable pageable);

	@Query("SELECT u FROM Bill u JOIN u.user s JOIN u.customer c "
			+ "WHERE s.username LIKE :x OR c.name LIKE :x AND  s.id = :sId OR c.id = :cId ")
	Page<Bill> searchAll(@Param("x") String name,
									@Param("sId") Long userId, @Param("cId") Long customerId,
									Pageable pageable);
}

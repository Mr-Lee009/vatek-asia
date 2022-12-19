package vn.com.vatekasia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.vatekasia.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

	@Query("SELECT u FROM User u WHERE u.username LIKE :x")
	Page<User> searchAll(@Param("x") String s, Pageable pageable);

	@Query("SELECT u FROM User u WHERE u.id = uId ")
	Page<User> searchById(@Param("uId") Long id, Pageable pageable);
}

package vn.com.vatekasia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.vatekasia.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	@Query("SELECT u FROM Room u WHERE u.name LIKE :x")
	Page<Room> searchAll(@Param("x") String s, Pageable pageable);

	@Query("SELECT u FROM Room u WHERE u.id = uId ")
	Page<Room> searchById(@Param("uId") Long id, Pageable pageable);
}

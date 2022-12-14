package vn.com.vatekasia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.vatekasia.entity.TypeServiceRoom;

@Repository
public interface TypeServiceRoomRepository extends JpaRepository<TypeServiceRoom, Long> {
//	@Query("SELECT u FROM TypeService u WHERE u.name LIKE :x")
//	Page<TypeServiceRoom> searchAll(@Param("x") String s, Pageable pageable);

	@Query("SELECT u FROM TypeServiceRoom u JOIN u.room r JOIN u.service s "
			+ "WHERE r.name LIKE :x OR s.name LIKE :x AND  r.id = :rId OR s.id = :sId ")
	Page<TypeServiceRoom> searchAll(@Param("x") String name, 
			@Param("rId") Long roomId, @Param("sId") Long serviceId,
			Pageable pageable);
}

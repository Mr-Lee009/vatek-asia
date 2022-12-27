package vn.com.vatekasia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.vatekasia.entity.Combo;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Long> {
    @Query("SELECT u FROM Combo u WHERE u.name LIKE :x")
    Page<Combo> searchAll(@Param("x") String s, Pageable pageable);
    @Query("SELECT u FROM Combo u JOIN u.room r " + "WHERE r.id = :rId")
    Page<Combo> searchByRoom(@Param("rId") Long roomId, Pageable pageable);
}

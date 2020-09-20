package com.DiplomskiRad.Videoteka.repositories;

import com.DiplomskiRad.Videoteka.domain.Cartoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartoonRepository extends JpaRepository<Cartoon,Long> {
    @Query(value = "Select * from cartoon as c where c.name like %:keyword% ", nativeQuery = true)
    List<Cartoon> findByKeyword(@Param("keyword") String keyword);
}

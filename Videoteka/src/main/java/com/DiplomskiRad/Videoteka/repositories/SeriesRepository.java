package com.DiplomskiRad.Videoteka.repositories;

import com.DiplomskiRad.Videoteka.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series,Long> {
    @Query(value = "Select * from series as s where s.name like %:keyword% ", nativeQuery = true)
    List<Series> findByKeyword(@Param("keyword") String keyword);
}

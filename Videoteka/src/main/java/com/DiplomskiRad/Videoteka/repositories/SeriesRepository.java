package com.DiplomskiRad.Videoteka.repositories;

import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series,Long> {
    @Query(value = "Select * from series as s where s.name like %:keyword% ", nativeQuery = true)
    List<Series> findByKeyword(@Param("keyword") String keyword);

    @Query(value = "Select s.id,s.seasons,s.year,g.name,s.name from series_genre as sg " +
            "inner join genre as g on (sg.genre_id = g.id) " +
            "inner join series as s on (sg.series_id = s.id) group by s.id",nativeQuery = true)
    List<Series> getAllSeriesGenres();

}

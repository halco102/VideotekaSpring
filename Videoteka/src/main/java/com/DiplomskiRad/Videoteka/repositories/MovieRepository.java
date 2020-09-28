package com.DiplomskiRad.Videoteka.repositories;

import com.DiplomskiRad.Videoteka.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MovieRepository extends  JpaRepository<Movie,Long> { //umjesto crud stavio sam JPA
    @Query(value = "Select * from movie as m where m.name like %:keyword% ", nativeQuery = true)
    List<Movie> findByKeyword(@Param("keyword") String keyword);

    @Query(value = "Select m.id,m.runtime,m.year,g.name,m.name from movie_genre as mg " +
            "inner join genre as g on mg.genre_id = g.id " +
            "inner join movie as m on mg.movie_id = m.id group by m.id",nativeQuery = true)
    List<Movie> getAllMovieGenres();

    @Query(value = "Select * from movie as m where m.id = :id",nativeQuery = true)
    Movie deleteMovieById(@Param("id") Long id);

    //m.id,m.name,m.runtime,m.year,g.name

}

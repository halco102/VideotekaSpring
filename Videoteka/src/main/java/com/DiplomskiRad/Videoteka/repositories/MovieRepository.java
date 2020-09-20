package com.DiplomskiRad.Videoteka.repositories;

import com.DiplomskiRad.Videoteka.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MovieRepository extends JpaRepository<Movie,Long> { //umjesto crud stavio sam JPA
    @Query(value = "Select * from movie as m where m.name like %:keyword% ", nativeQuery = true)
    List<Movie> findByKeyword(@Param("keyword") String keyword);

}

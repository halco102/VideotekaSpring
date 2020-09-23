package com.DiplomskiRad.Videoteka.repositories;

import com.DiplomskiRad.Videoteka.domain.Cartoon;
import com.DiplomskiRad.Videoteka.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartoonRepository extends JpaRepository<Cartoon,Long> {
    @Query(value = "Select * from cartoon as c where c.name like %:keyword% ", nativeQuery = true)
    List<Cartoon> findByKeyword(@Param("keyword") String keyword);

    @Query(value = "Select c.id,c.seasons,c.year,g.name,c.name from cartoon_genre as cg " +
            "inner join genre as g on cg.genre_id = g.id " +
            "inner join cartoon as c on cg.cartoon_id = c.id group by c.id",nativeQuery = true)
    List<Cartoon> getAllCartoonGenres();



}

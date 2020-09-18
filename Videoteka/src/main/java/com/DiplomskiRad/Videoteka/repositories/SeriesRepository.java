package com.DiplomskiRad.Videoteka.repositories;

import com.DiplomskiRad.Videoteka.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series,Long> {
}

package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.domain.Series;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeriesService {
    Series findSeriesById(Long id);
    List<Series> findAllSeries();
    List<Series> findByKeyword(String keyword);
    List<Series> getAllSeriesGenres();
}

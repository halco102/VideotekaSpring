package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Series;

import java.util.List;

public interface SeriesService {
    Series findSeriesById(Long id);
    List<Series> findAllSeries();
}

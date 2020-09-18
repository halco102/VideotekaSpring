package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Series;

import java.util.List;

public interface SeriesService {
    Series findById(Long id);
    List<Series> findAllSeries();
}

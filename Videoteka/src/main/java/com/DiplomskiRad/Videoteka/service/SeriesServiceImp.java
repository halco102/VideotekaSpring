package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.domain.Series;
import com.DiplomskiRad.Videoteka.repositories.SeriesRepository;
import com.DiplomskiRad.Videoteka.service.implementation.SeriesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesServiceImp implements SeriesService {
    private final SeriesRepository seriesRepository;

    public SeriesServiceImp(SeriesRepository seriesRepository){
        this.seriesRepository=seriesRepository;
    }

    @Override
    public Series findSeriesById(Long id) {
        return seriesRepository.findById(id).get();
    }

    @Override
    public List<Series> findAllSeries() {
        return seriesRepository.findAll();
    }

    @Override
    public List<Series> getAllSeriesGenres() {
        return seriesRepository.getAllSeriesGenres();
    }

    @Override
    public List<Series> findByKeyword(String keyword) {
        return seriesRepository.findByKeyword(keyword);
    }
}

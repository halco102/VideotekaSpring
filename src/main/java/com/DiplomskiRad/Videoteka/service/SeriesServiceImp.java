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
        if(keyword!=null){return seriesRepository.findByKeyword(keyword);}
        if(keyword==null){
            return seriesRepository.findAll();
        }
        return seriesRepository.getAllSeriesGenres();

    }

    @Override
    public void deleteById(Long id) {
        this.seriesRepository.deleteById(id);
    }

    @Override
    public void saveSeries(Series series) {
        this.seriesRepository.save(series);
    }

    @Override
    public List<Series> listOfSeriesOnGenre(String searchGenre) {
        return seriesRepository.listOfSeriesOnGenre(searchGenre);
    }

    @Override
    public List<Series> searchEngine(String searchGenre, String keyword) {
        if(keyword!=null && searchGenre == null){
            return this.seriesRepository.findByKeyword(keyword);
        }
        else if(keyword==null && searchGenre!=null){
            return this.seriesRepository.listOfSeriesOnGenre(searchGenre);
        }
        return this.seriesRepository.findAll();
    }

}

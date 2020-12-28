package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.domain.Series;
import com.DiplomskiRad.Videoteka.dto.SeriesDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeriesService {
    SeriesDto findSeriesById(Long id);
    List<SeriesDto> findAllSeries();
    List<SeriesDto> findByKeyword(String keyword);
    List<SeriesDto> getAllSeriesGenres();
    void deleteById(Long id);
    void saveSeries(SeriesDto series);
    List<SeriesDto>listOfSeriesOnGenre(String searchGenre);
    List<SeriesDto>searchEngine(String searchGenre,String keyword);

}

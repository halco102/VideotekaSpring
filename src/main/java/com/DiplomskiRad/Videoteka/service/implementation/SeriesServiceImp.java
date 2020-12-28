package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Series;
import com.DiplomskiRad.Videoteka.dto.SeriesDto;
import com.DiplomskiRad.Videoteka.mapper.SeriesMapper;
import com.DiplomskiRad.Videoteka.repositories.SeriesRepository;
import com.DiplomskiRad.Videoteka.service.SeriesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeriesServiceImp implements SeriesService {
    private final SeriesRepository seriesRepository;
    private final SeriesMapper seriesMapper;

    public SeriesServiceImp(SeriesRepository seriesRepository, SeriesMapper seriesMapper){
        this.seriesRepository=seriesRepository;
        this.seriesMapper = seriesMapper;
    }

    @Override
    public SeriesDto findSeriesById(Long id) {
        return this.seriesMapper.toDto(seriesRepository.findById(id).get());
    }

    @Override
    public List<SeriesDto> findAllSeries() {
        return seriesRepository.findAll().stream().map(seriesMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SeriesDto> getAllSeriesGenres() {
        return seriesRepository.getAllSeriesGenres().stream().map(seriesMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SeriesDto> findByKeyword(String keyword) {
        if(keyword!=null){return seriesRepository.findByKeyword(keyword).stream().map(seriesMapper::toDto).collect(Collectors.toList());}
        if(keyword==null){
            return seriesRepository.findAll().stream().map(seriesMapper::toDto).collect(Collectors.toList());
        }
        return seriesRepository.getAllSeriesGenres().stream().map(seriesMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public void deleteById(Long id) {
        this.seriesRepository.deleteById(id);
    }

    @Override
    public void saveSeries(SeriesDto series) {
        Series temp = new Series();
        temp = this.seriesMapper.toEntity(series);
        this.seriesRepository.save(temp);
    }

    @Override
    public List<SeriesDto> listOfSeriesOnGenre(String searchGenre) {
        return seriesRepository.listOfSeriesOnGenre(searchGenre).stream().map(seriesMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SeriesDto> searchEngine(String searchGenre, String keyword) {
        if(keyword!=null && searchGenre == null){
            return this.seriesRepository.findByKeyword(keyword).stream().map(seriesMapper::toDto).collect(Collectors.toList());
        }
        else if(keyword==null && searchGenre!=null){
            return this.seriesRepository.listOfSeriesOnGenre(searchGenre).stream().map(seriesMapper::toDto).collect(Collectors.toList());
        }
        return this.seriesRepository.findAll().stream().map(seriesMapper::toDto).collect(Collectors.toList());
    }

}

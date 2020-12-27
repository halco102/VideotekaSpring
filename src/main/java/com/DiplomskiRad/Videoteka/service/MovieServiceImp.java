package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Genre;
import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.dto.MovieDto;
import com.DiplomskiRad.Videoteka.mapper.MovieMapper;
import com.DiplomskiRad.Videoteka.repositories.MovieRepository;
import com.DiplomskiRad.Videoteka.service.implementation.GenreService;
import com.DiplomskiRad.Videoteka.service.implementation.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MovieServiceImp implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieServiceImp(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public MovieDto deleteMovieById(Long id) {
        return this.movieMapper.toDto(movieRepository.deleteMovieById(id));
    }


    @Override
    public MovieDto findMoviebyId(Long id) {
        return this.movieMapper.toDto(movieRepository.findById(id).get());
    }

    @Override
    public List<MovieDto> findAllMovies() {
        return movieRepository.findAll().stream().map(movieMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> getAllMovieGenres() {
        return movieRepository.getAllMovieGenres().stream().map(movieMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Invalid Movie Id " + id));
        movieRepository.deleteById(id);
    }


    @Override
    public void addNewMovie(MovieDto movie){
        Movie temp = new Movie();
        temp = movieMapper.toEntity(movie);
        this.movieRepository.save(temp);
    }

    @Override
    public void save(MovieDto movie) {
        Movie temp = new Movie();
        temp = movieMapper.toEntity(movie);
        this.movieRepository.save(temp);
        System.out.println("movie saved");
    }


    @Override
    public List<MovieDto> listOfMovieOnGenre(String searchGenre) {
        if(searchGenre!=null){
            return movieRepository.listOfMovieOnGenre(searchGenre).stream().map(movieMapper::toDto).collect(Collectors.toList());
        }
        return this.movieRepository.findAll().stream().map(movieMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> findByKeyword(String keyword) {

        //return movieRepository.findByKeyword(keyword);
        if(keyword!=null){
            return this.movieRepository.findByKeyword(keyword).stream().map(movieMapper::toDto).collect(Collectors.toList());
        }
        if(keyword==null){
            return this.movieRepository.findAll().stream().map(movieMapper::toDto).collect(Collectors.toList());
        }

        return this.movieRepository.getAllMovieGenres().stream().map(movieMapper::toDto).collect(Collectors.toList());

    }


    @Override
    public List<MovieDto> searchEngine(String searchGenre, String keyword) {
        if(keyword!=null && searchGenre == null){
            return this.movieRepository.findByKeyword(keyword).stream().map(movieMapper::toDto).collect(Collectors.toList());
        }
        else if(keyword==null && searchGenre!=null){
            return this.movieRepository.listOfMovieOnGenre(searchGenre).stream().map(movieMapper::toDto).collect(Collectors.toList());
        }
        return this.movieRepository.findAll().stream().map(movieMapper::toDto).collect(Collectors.toList());
    }
}

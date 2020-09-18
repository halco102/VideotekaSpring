package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService{

    private final MovieRepository movieRepository;

    public MovieServiceImp(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findMoviebyId(Long id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }
}

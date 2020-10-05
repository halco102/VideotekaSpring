package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Genre;
import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.repositories.MovieRepository;
import com.DiplomskiRad.Videoteka.service.implementation.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieServiceImp implements MovieService {

    private final MovieRepository movieRepository;


    public MovieServiceImp(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie deleteMovieById(Long id) {
        return movieRepository.deleteMovieById(id);
    }

    @Override
    public Movie findMoviebyId(Long id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findByKeyword(String keyword) {

        //return movieRepository.findByKeyword(keyword);
        if(keyword!=null){
            return this.movieRepository.findByKeyword(keyword);
        }
        if(keyword==null){
            return this.movieRepository.findAll();
        }

        return this.movieRepository.getAllMovieGenres();

    }

    @Override
    public List<Movie> getAllMovieGenres() {
        return movieRepository.getAllMovieGenres();
    }

    @Override
    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Invalid user Id " + id));
        movieRepository.deleteById(id);
    }


    @Override
    public void addNewMovie(Movie movie){
        this.movieRepository.save(movie);
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
        System.out.println("movie saved");
    }
}

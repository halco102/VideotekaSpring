package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Genre;
import com.DiplomskiRad.Videoteka.domain.Movie;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface MovieService {

    Movie findMoviebyId(Long id);

    List<Movie> findAllMovies();

    Movie deleteMovieById(@Param("id") Long id);

    List<Movie> findByKeyword(String keyword);

    List<Movie> getAllMovieGenres();

    void deleteMovie(Long id);

    void addNewMovie(Movie movie);

    void save(Movie movie);

    List<Movie>listOfMovieOnGenre(String searchGenre);

}

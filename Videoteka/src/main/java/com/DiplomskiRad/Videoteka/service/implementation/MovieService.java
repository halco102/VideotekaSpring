package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Movie;

import java.util.List;

public interface MovieService {

    Movie findMoviebyId(Long id);

    List<Movie> findAllMovies();

    void deleteById(Long id);

    List<Movie> findByKeyword(String keyword);

}

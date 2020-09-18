package com.DiplomskiRad.Videoteka.service;

import com.DiplomskiRad.Videoteka.domain.Movie;

import java.util.List;

public interface MovieService {

    Movie findMoviebyId(Long id);

    List<Movie> findAllMovies();

}

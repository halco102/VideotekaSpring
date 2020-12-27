package com.DiplomskiRad.Videoteka.service.implementation;

import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.dto.MovieDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieService {

    MovieDto findMoviebyId(Long id);

    List<MovieDto> findAllMovies();

    MovieDto deleteMovieById(@Param("id") Long id);

    List<MovieDto> findByKeyword(String keyword);

    List<MovieDto> getAllMovieGenres();

    void deleteMovie(Long id);

    void addNewMovie(MovieDto movie);

    void save(MovieDto movie);

    List<MovieDto>listOfMovieOnGenre(String searchGenre);

    List<MovieDto>searchEngine(String searchGenre,String keyword);


}

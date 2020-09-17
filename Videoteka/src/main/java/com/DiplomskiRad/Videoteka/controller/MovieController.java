package com.DiplomskiRad.Videoteka.controller;


import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.repositories.MovieRepository;
import com.DiplomskiRad.Videoteka.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping(MovieController.BASE_URL)
public class MovieController {

    public static final String BASE_URL="/api/v1/movies";
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    List<Movie> findAllMovies(){
        return  movieService.findAllMovies();
    }

    @GetMapping("/{id}")
    Movie findMoviebyId(@PathVariable  Long id){
        return this.movieService.findMoviebyId(id);
    }

}

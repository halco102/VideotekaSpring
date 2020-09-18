package com.DiplomskiRad.Videoteka.controller;


import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.repositories.MovieRepository;
import com.DiplomskiRad.Videoteka.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller

@RequestMapping(MovieController.BASE_URL)
public class MovieController {

    public static final String BASE_URL="/api/v1/videoteka/";

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


/*@RestController
    @GetMapping("/movies")
    List<Movie> findAllMovies(){
        return  movieService.findAllMovies();
    }

    @GetMapping("/{id}")
    Movie findMoviebyId(@PathVariable  Long id){
        return this.movieService.findMoviebyId(id);
    }
*/
    @RequestMapping()
    public  String getIndex(){
        return "videoteka/index.html";
    }

    @RequestMapping("/movies")
    public String getMovies(Model model){
        model.addAttribute("movies",movieService.findAllMovies());
        return "videoteka/movies/movies.html";
    }

}

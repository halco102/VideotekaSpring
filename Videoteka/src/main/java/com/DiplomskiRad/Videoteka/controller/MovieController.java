package com.DiplomskiRad.Videoteka.controller;


import com.DiplomskiRad.Videoteka.service.implementation.GenreService;
import com.DiplomskiRad.Videoteka.service.implementation.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(MovieController.BASE_URL)
public class MovieController {

    public static final String BASE_URL="/api/v1/videoteka";

    private final MovieService movieService;

    public MovieController(MovieService movieService){
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

    @GetMapping()
    public  String getIndex(){
        return "videoteka/index.html";
    }

    @GetMapping("/movies")
    public String getMovies(Model model,String keyword){

        if(keyword != null){
            model.addAttribute("movies",movieService.findByKeyword(keyword));
        }else {
            model.addAttribute("movies", movieService.findAllMovies());
            model.addAttribute("movies",movieService.getAllMovieGenres());

        }


        return "videoteka/entertainment/movies.html";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(Model model, @PathVariable Long id){
        model.addAttribute("movies",movieService.findMoviebyId(id));
        return "videoteka/entertainment/movies.html";
    }


}

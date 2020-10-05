package com.DiplomskiRad.Videoteka.controller;


import com.DiplomskiRad.Videoteka.domain.Genre;
import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.repositories.GenreRepository;
import com.DiplomskiRad.Videoteka.service.implementation.GenreService;
import com.DiplomskiRad.Videoteka.service.implementation.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(MovieController.BASE_URL)
public class MovieController {

    public static final String BASE_URL="/api/v1/videoteka";

    private final MovieService movieService;
    private final GenreService genreService;

    public MovieController(MovieService movieService, GenreService genreService, GenreRepository genreRepository){
        this.genreService=genreService;
        this.movieService = movieService;
    }

    @GetMapping()
    public  String getIndex(){
        return "videoteka/index.html";
    }

    //for user
    @GetMapping("/movies")
    public String getMovies(Model model,
                            String keyword,
                            String searchGenre){
        //Kasnije prepravit da logika bude u service
/*        if(keyword!=null && searchGenre==null) {
            model.addAttribute("movies", movieService.findByKeyword(keyword));
            model.addAttribute("genres", genreService.findAllGenre());
        }else if(keyword==null && searchGenre!=null ){
            model.addAttribute("movies",movieService.listOfMovieOnGenre(searchGenre));
            model.addAttribute("genres", genreService.findAllGenre());
        }else{
            model.addAttribute("movies",movieService.findAllMovies());
            model.addAttribute("genres", genreService.findAllGenre());
        }*/

        model.addAttribute("movies",movieService.searchEngine(searchGenre,keyword));
        model.addAttribute("genres",genreService.findAllGenre());

       return  "videoteka/entertainment/movies.html";
    }

    @GetMapping("/movies/{id}")
    public String getMovieById(Model model, @PathVariable Long id){
        model.addAttribute("movies", movieService.findMoviebyId(id));
        return "videoteka/entertainment/movies.html";
    }
    //end

    //for admin
    @GetMapping("/deleteMovie/{id}")
    public String deleteId(Model model, @PathVariable Long id){
      movieService.deleteMovie(id);
      model.addAttribute("movies",movieService.findAllMovies());
      return "redirect:/api/v1/videoteka/admin-add-delete/movies";
    }


    //update
    @GetMapping("/admin-add-delete/movies/update/{id}")
    public String editMovie(Model model, @PathVariable Long id, String keyword){

            Movie updateMovies= movieService.findMoviebyId(id);
            List<Genre> genres = new ArrayList<>();
            genreService.findAllGenre().iterator().forEachRemaining(genres::add);
            model.addAttribute("updateMovies",updateMovies);
            model.addAttribute("g",genreService.findAllGenre());
            model.addAttribute("m",movieService.findByKeyword(keyword));


        return "videoteka/admin/edit/edit-movie.html";
    }

    @PostMapping("/admin-add-delete/movies/update")
    public String edit(Model model,
                       @Valid @ModelAttribute("updateMovies") Movie updateMovies,
                       @RequestParam("ids") List<Genre> genres,
                       BindingResult result){

        for(int i = 0 ; i < genres.size();i++ ){
            updateMovies.getGenres().add(genres.get(i));
        }
         movieService.save(updateMovies);
        return "redirect:/api/v1/videoteka/admin-add-delete/movies";
    }
    //end update

    @GetMapping("/admin-add-delete/movies")
    public  String addEntertainment(Model model,String keyword){
        Movie movies = new Movie();
        model.addAttribute("movies",movies);
        List<Genre> genres = new ArrayList<>();
        genreService.findAllGenre().iterator().forEachRemaining(genres::add);
        model.addAttribute("g",genres);
        model.addAttribute("m",movieService.findByKeyword(keyword));

        return "videoteka/admin/add-movies.html";
    }


    @PostMapping("/admin-add-delete/movies")
    public String submitForm(@Valid @ModelAttribute("movies") Movie movies,
                             @RequestParam("ids") List<Genre> genres,
                             Model model){

        for(int i = 0 ; i < genres.size();i++ ){
            movies.getGenres().add(genres.get(i));
        }
        movieService.save(movies);
        return "redirect:/api/v1/videoteka/admin-add-delete/movies";
    }
//end


}

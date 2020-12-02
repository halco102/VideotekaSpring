package com.DiplomskiRad.Videoteka.controller;


import com.DiplomskiRad.Videoteka.domain.Genre;
import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.domain.Series;
import com.DiplomskiRad.Videoteka.service.implementation.GenreService;
import com.DiplomskiRad.Videoteka.service.implementation.SeriesService;
import com.DiplomskiRad.Videoteka.service.implementation.StarService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(MovieController.BASE_URL)
public class SeriesController {

    private final SeriesService seriesService;
    private final GenreService genreService;
    private final StarService starService;


    public SeriesController(SeriesService seriesService,GenreService genreService,StarService starService) {
        this.seriesService = seriesService;
        this.genreService=genreService;
        this.starService=starService;

    }

    @GetMapping("/series")
    public String getSeries(Model model,String keyword,String searchGenre){
        model.addAttribute("series",seriesService.searchEngine(searchGenre,keyword));
        model.addAttribute("genres",genreService.findAllGenre());
        model.addAttribute("stars",starService.getAllStars());
        model.addAttribute("userName",UserController.displayUsername);

        return "videoteka/entertainment/series.html";
    }

    @GetMapping("series/{id}")
    public String getSeriesById(Model model, @PathVariable Long id){
        model.addAttribute("series",seriesService.findSeriesById(id));
        return "videoteka/entertainment/series.html";
    }

    //for admin
    @GetMapping("/delete-series/{id}")
    public String deleteId(Model model, @PathVariable Long id){
        seriesService.deleteById(id);
        model.addAttribute("series",seriesService.findAllSeries());
        return "redirect:/api/v1/videoteka/admin-add-delete/series";
    }

    @GetMapping("/admin-add-delete/series")
    public  String addEntertainment(Model model,String keyword){
        Series series= new Series();
        model.addAttribute("series",series);
        List<Genre> genres = new ArrayList<>();
        genreService.findAllGenre().iterator().forEachRemaining(genres::add);
        model.addAttribute("g",genres);
        model.addAttribute("se",seriesService.findByKeyword(keyword));

        return "videoteka/admin/add-series.html";
    }


//update
    @GetMapping("/admin-add-delete/series/update/{id}")
    public String editSeries(Model model, @PathVariable Long id, Movie movie, String keyword){
        Series updateMovies= seriesService.findSeriesById(id);
        List<Genre> genres = new ArrayList<>();
        genreService.findAllGenre().iterator().forEachRemaining(genres::add);
        model.addAttribute("updateSeries",updateMovies);
        model.addAttribute("g",genreService.findAllGenre());
        model.addAttribute("m",seriesService.findByKeyword(keyword));

        return "videoteka/admin/edit/edit-series.html";
    }



    @PostMapping("/admin-add-delete/series/update")
    public String submitForm(@Valid @ModelAttribute("updateSeries") Series series,
                             @RequestParam("ids") List<Genre> genres,
                             Model model){

        for(int i = 0 ; i < genres.size();i++ ){
            series.getGenres().add(genres.get(i));
        }
        seriesService.saveSeries(series);
        return "redirect:/api/v1/videoteka/admin-add-delete/series";
    }
//end update



}

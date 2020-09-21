package com.DiplomskiRad.Videoteka.controller;


import com.DiplomskiRad.Videoteka.service.implementation.SeriesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(MovieController.BASE_URL)
public class SeriesController {

    private final SeriesService seriesService;


    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;

    }

    @GetMapping("/series")
    public String getSeries(Model model,String keyword){
        if(keyword!=null){
         model.addAttribute("series",seriesService.findByKeyword(keyword));
        }else {
            model.addAttribute("series", seriesService.findAllSeries());
        }

        return "videoteka/entertainment/series.html";
    }

    @GetMapping("series/{id}")
    public String getSeriesById(Model model, @PathVariable Long id){
        model.addAttribute("series",seriesService.findSeriesById(id));
        return "videoteka/entertainment/series.html";
    }


}

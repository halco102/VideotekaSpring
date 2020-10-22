package com.DiplomskiRad.Videoteka.controller;

import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.domain.Order;
import com.DiplomskiRad.Videoteka.domain.User;
import com.DiplomskiRad.Videoteka.service.implementation.MovieService;
import com.DiplomskiRad.Videoteka.service.implementation.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(MovieController.BASE_URL)
public class OrderController {

    private OrderService orderService;
    private MovieService movieService;

    public OrderController(OrderService orderService,
                           MovieService movieService){
        this.orderService=orderService;
        this.movieService=movieService;
    }

    /*
    * na osnovu id treba kupovat filmove
    *
    * */

    @GetMapping("/movies/buy/{id}") //save-a mi filmove treba prebacit u service logiku i da se ne mogu kupovati isti filmovi
    public String getMovieById(Model model, @PathVariable Long id){
        model.addAttribute("movies", movieService.findMoviebyId(id));
        Order order = new Order();
        order.setMovie(movieService.findMoviebyId(id));
        System.out.println(order.getMovie().getName());
        orderService.saveOrder(order);
        return "redirect:/api/v1/videoteka/movies";
    }

    @PostMapping("/ordered")
    public String saveOrder(Model model, @ModelAttribute("movies")Movie movie, @ModelAttribute("users")User user){


        return "redirect:/api/v1/videoteka/movies";
    }


}

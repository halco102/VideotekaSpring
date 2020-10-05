package com.DiplomskiRad.Videoteka.controller;

import com.DiplomskiRad.Videoteka.domain.Cartoon;
import com.DiplomskiRad.Videoteka.domain.Genre;
import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.domain.Series;
import com.DiplomskiRad.Videoteka.service.implementation.CartoonService;
import com.DiplomskiRad.Videoteka.service.implementation.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(MovieController.BASE_URL)
public class CartoonController {

    private final CartoonService cartoonService;
    private final GenreService genreService;

    public CartoonController(CartoonService cartoonService,
                             GenreService genreService) {
        this.cartoonService = cartoonService;
        this.genreService=genreService;
    }

    @GetMapping("/cartoons")
    public String getCartoons(Model model,String keyword){
        if(keyword!=null){
            model.addAttribute("cartoons", cartoonService.findByKeyword(keyword));
        }else {
            model.addAttribute("cartoons", cartoonService.findAllCartoons());
            model.addAttribute("cartoons",cartoonService.getAllCartoonGenres());
        }

        return "videoteka/entertainment/cartoon.html";
    }

    @GetMapping("cartoons/{id}")
    public String getCartoonById(@PathVariable Long id, Model model){
        model.addAttribute("cartoons",cartoonService.findCartoonById(id));
        return "videoteka/entertainment/cartoon.html";
    }


    //for admin
    @GetMapping("/delete-cartoon/{id}")
    public String deleteId(Model model, @PathVariable Long id){
        cartoonService.deleteCartoonById(id);
        model.addAttribute("cartoons",cartoonService.findAllCartoons());
        return "redirect:/api/v1/videoteka/admin-add-delete/cartoons";
    }

    @GetMapping("/edit-cartoon/{id}")
    public String editMovie(Model model, @PathVariable Long id, Movie movie){
        //Movie newMovie= movieService.findMoviebyId(movie.getId());
        return "redirect:/api/v1/videoteka/admin-add-delete/movies";
    }

    @GetMapping("/admin-add-delete/cartoons")
    public  String addEntertainment(Model model,String keyword){
        Cartoon cartoon= new Cartoon();
        model.addAttribute("cartoons",cartoon);
        List<Genre> genres = new ArrayList<>();
        genreService.findAllGenre().iterator().forEachRemaining(genres::add);
        model.addAttribute("genre",genres);
        model.addAttribute("cartoon",cartoonService.findByKeyword(keyword));

        return "videoteka/admin/add-cartoons.html";
    }


    @PostMapping("/admin-add-delete/cartoons")
    public String submitForm(@Valid @ModelAttribute("cartoons")Cartoon cartoon,
                             @RequestParam("ids") List<Genre> genres,
                             Model model){

        for(int i = 0 ; i < genres.size();i++ ){
            cartoon.getGenres().add(genres.get(i));
        }
        cartoonService.addCartoon(cartoon);
        System.out.println("Saved");
        return "redirect:/api/v1/videoteka/admin-add-delete/cartoons";
    }
//end


}

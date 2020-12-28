package com.DiplomskiRad.Videoteka.controller;

import com.DiplomskiRad.Videoteka.domain.Movie;
import com.DiplomskiRad.Videoteka.dto.CartoonDto;
import com.DiplomskiRad.Videoteka.dto.GenreDto;
import com.DiplomskiRad.Videoteka.service.CartoonService;
import com.DiplomskiRad.Videoteka.service.CreatorService;
import com.DiplomskiRad.Videoteka.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(MovieController.BASE_URL)
@Slf4j
public class CartoonController {

    private final CartoonService cartoonService;
    private final GenreService genreService;
    private final CreatorService creatorService;


    public CartoonController(CartoonService cartoonService,
                             GenreService genreService,
                             CreatorService creatorService) {
        this.cartoonService = cartoonService;
        this.genreService=genreService;
        this.creatorService=creatorService;
    }

    @GetMapping("/cartoons")
    public String getCartoons(Model model,String keyword,String searchGenre){
        model.addAttribute("cartoons",this.cartoonService.searchEngine(searchGenre,keyword));
        model.addAttribute("genres",this.genreService.findAllGenre());
        model.addAttribute("creators",this.creatorService.getAllCreators());
        model.addAttribute("userName",UserController.displayUsername);

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


    @GetMapping("/admin-add-delete/cartoons")
    public  String addEntertainment(Model model,String keyword){
        CartoonDto cartoon= new CartoonDto();
        model.addAttribute("cartoons",cartoon);
        List<GenreDto> genres = new ArrayList<>();
        genreService.findAllGenre().iterator().forEachRemaining(genres::add);
        model.addAttribute("genre",genres);
        model.addAttribute("cartoon",cartoonService.findByKeyword(keyword));

        return "videoteka/admin/add-cartoons.html";
    }



    @GetMapping("/admin-add-delete/cartoons/update/{id}")
    public String editMovie(Model model, @PathVariable Long id, Movie movie, String keyword){

        CartoonDto updateCartoons= cartoonService.findCartoonById(id);
        List<GenreDto> genres = new ArrayList<>();
       // genreService.findAllGenre().iterator().forEachRemaining(genres::add); treba dto uradit
        model.addAttribute("updateCartoons",updateCartoons);
        model.addAttribute("g",genreService.findAllGenre());
        model.addAttribute("c",cartoonService.findByKeyword(keyword));


        return "videoteka/admin/edit/edit-cartoon.html";
    }

    @PostMapping("/admin-add-delete/cartoons/update")
    public String edit(@Valid @ModelAttribute("updateCartoons") CartoonDto cartoonDto,
                             @RequestParam("ids") List<GenreDto> genres,
                             Model model){

        for(int i = 0 ; i < genres.size();i++ ){
            cartoonDto.getGenres().add(genres.get(i));
        }
        cartoonService.addCartoon(cartoonDto);
        log.info("Saved cartoon");
        return "redirect:/api/v1/videoteka/admin-add-delete/cartoons";
    }
//end


}

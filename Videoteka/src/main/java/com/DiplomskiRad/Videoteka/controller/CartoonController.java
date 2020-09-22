package com.DiplomskiRad.Videoteka.controller;

import com.DiplomskiRad.Videoteka.service.implementation.CartoonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(MovieController.BASE_URL)
public class CartoonController {

    private final CartoonService cartoonService;

    public CartoonController(CartoonService cartoonService) {
        this.cartoonService = cartoonService;
    }

    @GetMapping("/cartoon")
    public String getCartoons(Model model,String keyword){
        if(keyword!=null){
            model.addAttribute("cartoons",cartoonService.findByKeyword(keyword));
        }else {
            model.addAttribute("cartoons", cartoonService.findAllCartoons());
            model.addAttribute("cartoons",cartoonService.getAllCartoonGenres());
        }

        return "videoteka/entertainment/cartoon.html";
    }

    @GetMapping("cartoon/{id}")
    public String getCartoonById(@PathVariable Long id, Model model){
        model.addAttribute("cartoons",cartoonService.findCartoonById(id));
        return "videoteka/entertainment/cartoon.html";
    }
}

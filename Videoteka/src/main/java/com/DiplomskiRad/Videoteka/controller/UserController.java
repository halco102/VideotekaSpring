package com.DiplomskiRad.Videoteka.controller;


import com.DiplomskiRad.Videoteka.domain.User;
import com.DiplomskiRad.Videoteka.service.implementation.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(MovieController.BASE_URL)
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }


    //Login of user
    @GetMapping("")
    public String showLoginPage(Model model){
        User user = new User();
        model.addAttribute("users",user);
        return "videoteka/login/sign-in.html";
    }

    @GetMapping("/error")
    public String userDoesNotExist(){
        return "videoteka/login/error.html";
    }


    @PostMapping("/register")
    public String test2(Model model,@Valid @ModelAttribute("users") User user){

        if(userService.exists(user.getUserName(),user.getPassword())!=true){
            return "redirect:/api/v1/videoteka/error";
        }

        return "redirect:/api/v1/videoteka/index";

    }
    //end Login



}

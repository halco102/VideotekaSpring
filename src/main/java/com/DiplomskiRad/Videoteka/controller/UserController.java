package com.DiplomskiRad.Videoteka.controller;


import com.DiplomskiRad.Videoteka.domain.Role;
import com.DiplomskiRad.Videoteka.domain.User;
import com.DiplomskiRad.Videoteka.service.implementation.RoleService;
import com.DiplomskiRad.Videoteka.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping(MovieController.BASE_URL)
public class UserController {


    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    public static String displayUsername;

    @GetMapping("/index")
    public  String getIndex(Model model){
       //check koji user je loged in trenutno
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        displayUsername = authentication.getName();
        model.addAttribute("userName",displayUsername);
        return "videoteka/index.html";
    }

    @GetMapping("")
    public String getLogin(){
        return "redirect:/api/v1/videoteka/login";
    }

    //Login of user
    @GetMapping("/login")
    public String showLoginPage(Model model){
        User user = new User();
        model.addAttribute("users",user);

        return "videoteka/login/sign-in.html";
    }




    /*
    @PostMapping("/login")
    public String register(Model model,@Valid @ModelAttribute("users") User user){


        if(userService.exists(user.getUserName(),user.getPassword())!=true){
            System.out.println("Hello world");
            return "videoteka/login/sign-in.html";
        }else {
            System.out.println("No");
            return "redirect:/api/v1/videoteka/index";
        }
    }*/
    //end Login

    @GetMapping("/register")
    public String createAccount(Model model){
        User user = new User();
        model.addAttribute("users",user);
        return "videoteka/login/create-account.html";
    }

    //test purpose
    @Autowired
            public RoleService roleService;

    Role role = new Role("USER");

    //end

    @PostMapping("/create-account")
    public String createAccount(@ModelAttribute("users")  User user,
                                BindingResult result,
                                Model model,
                                Error error){


        //provjeriti da li postoji user u bazi, ako postoji baci error ako ne nastavi dalje sa pregledom, tj provjeri jel
        //email validan ili je vec koji postoji u bazi
            roleService.save(role); //test line


            if (result.hasErrors()) {
                return "videoteka/login/create-account.html";
            }
            if(this.userService.validation(user.getUserName(),user.geteMail(),user.getPassword(),user.getConfirmPassword())==true){

                user.getUserRoleSet().add(role); //test purpose
                this.userService.save(user);
                return "redirect:/api/v1/videoteka/login";
            }

            return "videoteka/login/create-account.html";

    }//end createAccount method

    @GetMapping("/logout")
    public String logoutController(){
        return "videoteka/login/sign-in.html";
    }

}

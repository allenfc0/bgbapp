package com.bakerygb.bgbapp.controllers;


import com.bakerygb.bgbapp.models.User;
import com.bakerygb.bgbapp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
public class HomeController {

    //private User newUser;

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService){
        this.userService = userService;
    }

    @GetMapping({"/", "/index"})
    public String getHome(Model m) {
        m.addAttribute("loginBtn", "Log In");
        m.addAttribute("signupBtn", "Sign Up");
        return "index";
    }

    @GetMapping({"/about"})
    public String getAbout() {

        return "about";
    }

    @GetMapping({"/jobs"})
    public String getJobs() {

        return "jobs";
    }

    @GetMapping({"/services"})
    public String getServices() {

        return "services";
    }

    @GetMapping({"/contact"})
    public String getContact() {

        return "contact";
    }

    @RequestMapping({"/login"})
    public String getLogin() {

        return "login";
    }

    @RequestMapping("/signup")
    public String getSignup() {

        return "signup";
    }

    @RequestMapping({"/logout-success"})
    public String getLogout() {

        return "login";
    }


}





















package com.bakerygb.bgbapp.controllers;

import com.bakerygb.bgbapp.models.User;
import com.bakerygb.bgbapp.models.UserPrinciple;
import com.bakerygb.bgbapp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Slf4j
public class CustomerController {

    private final UserService userService;

    @Autowired
    public CustomerController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/processUser")
    public String getProcess(@RequestParam String name,
                             @RequestParam String username,
                             @RequestParam String email,
                             @RequestParam String password) {

        User newUser = new User(name,
                username,
                email,
                BCrypt.hashpw(password, BCrypt.gensalt(10)),
                "CUSTOMER");

        userService.addUser(newUser);
        return "login";
    }

    @RequestMapping(value = "/user")
    public String getUser(Model m) {
        m.addAttribute("logoutBtn", "Logout");
        return "index";
    }


}

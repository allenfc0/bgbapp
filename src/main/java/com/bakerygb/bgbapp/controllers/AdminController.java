package com.bakerygb.bgbapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class AdminController {

    /*@GetMapping({"/login"})
    public String getLogin(@RequestParam("username") String userId,
                           @RequestParam("password") String password) {
        //I will be accessing login credentials using Spring Security
        return "";
    }*/

    @GetMapping("/admin")
    public String getAdmin() {

        return "admin";
    }

}

package com.bakerygb.bgbapp.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping({"/", "/index"})
    public String getHome() {

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
}





















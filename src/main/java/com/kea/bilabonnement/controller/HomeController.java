package com.kea.bilabonnement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // map to home/index page
    @GetMapping("/")
    public String home(){
        return "index";
    }

    // map to home/index page
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    // show the error page
    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}

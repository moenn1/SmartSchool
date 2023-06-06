package com.smartschool.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/home")
    public String home(){
        return "home";
    }


}

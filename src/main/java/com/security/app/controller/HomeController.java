package com.security.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String getHome(){
        return "Welcome to home page of this project";
    }

    @GetMapping("/panel")
    public String getPanel(){
        return "Login Successfully";
    }

}

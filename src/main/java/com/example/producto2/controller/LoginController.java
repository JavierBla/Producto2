package com.example.producto2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showHome(){
        return "index";
    }

    @GetMapping("/auth/login")
    public String showLoginPage(){
        return "login";
    }

}
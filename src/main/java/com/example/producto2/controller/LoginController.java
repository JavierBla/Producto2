package com.example.producto2.controller;

import com.example.producto2.model.dao.MenuDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private MenuDaoImpl menu;

    @GetMapping("/")
    public String showHome(Model model){
        model.addAttribute("menus", menu.findAll());
        model.addAttribute("currentPage", "home");
        return "home_menu_list";
    }

    @GetMapping("/auth/login")
    public String showLoginPage(){
        return "login";
    }

}

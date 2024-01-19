package com.example.producto2.controller;

import com.example.producto2.model.dao.MenuDaoImpl;
import com.example.producto2.model.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuController {
    @Autowired
    private MenuDaoImpl menuService;

    @GetMapping("/menus")
    public String getMenus(Model model){
        model.addAttribute("menus", menuService.findAll());
        model.addAttribute("currentPage", "menus");
        return "menus";
    }

    @GetMapping("/menu/{id}")
    public String getMenuDetail(Model model, @PathVariable Long id) {
        Menu menu = menuService.findByID(id);
        if(menu != null) {
            model.addAttribute("menu", menu);
            model.addAttribute("currentPage", "menus");
        }
        return "edit_menu";
    }

    @PostMapping("/menu/update/{id}")
    public String updateMenu(@PathVariable("id") Long id,
                             @ModelAttribute("menu") Menu menuDetails) {
        Menu menu = menuService.findByID(id);
        if(menu != null){
            menu.setNombre(menuDetails.getNombre());
            menu.setPrecio(menuDetails.getPrecio());
            menuService.update(menu);
        }
        return "redirect:/menu/" + id;
    }

    @GetMapping("/menu/create")
    public String createMenu(Model model) {
        model.addAttribute("menu", new Menu());
        model.addAttribute("currentPage", "menus");
        return "create_menu";
    }

    @PostMapping("/menu")
    public String newMenu(Model model, @ModelAttribute("menu") Menu menu) {
        menuService.save(menu);
        return "redirect:/menus";
    }
}

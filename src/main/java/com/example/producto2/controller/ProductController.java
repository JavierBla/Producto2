package com.example.producto2.controller;


import com.example.producto2.model.dao.ProductoDaoImpl;
import com.example.producto2.model.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {
    @Autowired
    private ProductoDaoImpl ProductService;

    @GetMapping("/product")
    public String products(Model model){
        model.addAttribute("product",ProductService.findAll());
        model.addAttribute("currentPage", "product");
        return "product";
    }

    @GetMapping("/product/create")
    public String createProduct(Model model) {
        model.addAttribute("product", new Producto());
        model.addAttribute("currentPage", "product");
        return "create_product";
    }

    @PostMapping("/product/save")
    public String newMenu(Model model, @ModelAttribute("product") Producto product) {
        ProductService.save(product);
        return "redirect:/product";
    }

}

package com.example.producto2.controller;


import com.example.producto2.model.dao.ProductoDaoImpl;
import com.example.producto2.model.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/product/{id}")
    public String getMenuDetail(Model model, @PathVariable Integer id) {
        Producto producto = ProductService.findByID(id);
        if(producto != null) {
            model.addAttribute("product", producto);
            model.addAttribute("currentPage", "product");
        }
        return "edit_product";
    }

    @PostMapping("/product/update/{id}")
    public String updateProduct(@PathVariable("id") Integer id,
                                @ModelAttribute("product") Producto productDetails) {
        Producto producto = ProductService.findByID(id);
        if (producto != null) {
            producto.setNombre(productDetails.getNombre());
            producto.setPrecio(productDetails.getPrecio());
            ProductService.update(producto);
        }
        return "redirect:/product/{id}";
    }

    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(Model model, @ModelAttribute("product") Producto producto) {
        ProductService.delete(producto.getId());
        return "redirect:/product";
    }

    @PostMapping("/product/save")
    public String newProduct(Model model, @ModelAttribute("product") Producto product) {
        ProductService.save(product);
        return "redirect:/product";
    }

}

package com.example.producto2.controller;

import com.example.producto2.model.entity.Menu;
import com.example.producto2.model.entity.Pedido;
import org.springframework.ui.Model;
import com.example.producto2.model.dao.PedidoDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PedidoController {

    @Autowired
    private PedidoDaoImpl pedidoDao;

    @GetMapping("/pedidos")
    public String getPedidos(Model model) {
        model.addAttribute("pedidos", pedidoDao.findAll());
        model.addAttribute("currentPage", "pedidos");
        return "pedidos";
    }

    @GetMapping("/pedido/{id}")
    public String getPedidoDetail(Model model, @PathVariable int id) {
        Pedido pedido = pedidoDao.findById(id);
        if(pedido != null) {
            model.addAttribute("pedido", pedido);
            model.addAttribute("currentPage", "pedidos");
        }
        return "edit_pedido";
    }

    @PostMapping("/pedido/update/{id}")
    public String updateMenu(@PathVariable("id") int id,
                             @ModelAttribute("menu") Pedido pedidoDetails) {
        Pedido pedido = pedidoDao.findById(id);
        if(pedido != null){
            pedido.setDireccion(pedidoDetails.getDireccion());
            pedidoDao.update(pedido);
        }
        return "redirect:/pedido/" + id;
    }

    @GetMapping("/pedido/create")
    public String createMenu(Model model) {
        model.addAttribute("pedido", new Menu());
        model.addAttribute("currentPage", "pedido");
        return "create_pedido";
    }

    @PostMapping("/pedido/save")
    public String newMenu(Model model, @ModelAttribute("pedido") Pedido pedido) {
        pedidoDao.save(pedido);
        return "redirect:/";
    }
}

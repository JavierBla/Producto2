package com.example.producto2.seeds;

import com.example.producto2.model.entity.*;
import com.example.producto2.repository.MenuRepository;
import com.example.producto2.repository.PedidoRepository;
import com.example.producto2.repository.ProductRepository;
import com.example.producto2.repository.TipoRepository;

import java.util.ArrayList;


public class Seeds {
    private MenuRepository menuRepository;
    private ProductRepository productRepository;
    private TipoRepository tipoRepository;
    private PedidoRepository pedidoRepository;

    public Seeds(MenuRepository menuRepository, ProductRepository productRepository, TipoRepository tipoRepository, PedidoRepository pedidoRepository)  {
        this.menuRepository = menuRepository;
        this.productRepository = productRepository;
        this.tipoRepository = tipoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public void generateSeeds(){
        Menu menuLibanes = new Menu("Libanes", 30.5);
        Menu menuVeggie = new Menu("Veggie", 20);
        Menu menuBurguer = new Menu("Burger", 25);
        menuRepository.save(menuLibanes);
        menuRepository.save(menuVeggie);
        menuRepository.save(menuBurguer);

        Tipo tipo = new Tipo("Comestible","Producto comestible");
        tipoRepository.save(tipo);

        Producto productPollo = new Producto("Pollo",5.00, tipo);
        Producto productSeitan = new Producto("Seitan",7.00, tipo);
        Producto productTofu = new Producto("Tofu",6.50, tipo);
        Producto productTernera = new Producto("Ternera",5.50, tipo);
        Producto productSetas = new Producto("Setas",2.00, tipo);
        productRepository.save(productPollo);
        productRepository.save(productSeitan);
        productRepository.save(productTofu);
        productRepository.save(productTernera);
        productRepository.save(productSetas);

        Usuario user = new Usuario("ignacio","pruebas","user","secret");
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(productPollo);
        productos.add(productSeitan);
        Pedido pedido1 = new Pedido(1, "Mi casa", user, productos);
        //pedidoRepository.save(pedido1);
    }
}
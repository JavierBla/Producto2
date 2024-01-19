package com.example.producto2.seeds;

import com.example.producto2.model.entity.*;
import com.example.producto2.repository.*;

import java.util.HashSet;


public class Seeds {
    private MenuRepository menuRepository;
    private ProductRepository productRepository;
    private TipoRepository tipoRepository;
    private PedidoRepository pedidoRepository;
    private UserRepository userRepository;

    public Seeds(MenuRepository menuRepository, ProductRepository productRepository, TipoRepository tipoRepository, PedidoRepository pedidoRepository, UserRepository userRepository)  {
        this.menuRepository = menuRepository;
        this.productRepository = productRepository;
        this.tipoRepository = tipoRepository;
        this.pedidoRepository = pedidoRepository;
        this.userRepository = userRepository;
    }

    public void generateSeeds(){
        generateMenus();
        generateProducts();
        generatePedido();
        generateUsuarios();
    }

    private void generateUsuarios() {
        Usuario user = new Usuario("user@example.com","user","hola01");
        Usuario admin = new Usuario("admin@example.com","admin","admin01");

        userRepository.save(user);
        userRepository.save(admin);
    }

    private void generatePedido() {
        Pedido pedido2 = new Pedido(156579, "C/San Juan 45");
        Pedido pedido3 = new Pedido(156580, "Avda. Primavera 12");
        Pedido pedido4 = new Pedido(156581, "Plaza Mayor 8");
        Pedido pedido5 = new Pedido(156582, "Callejón del Arte 15");
        Pedido pedido6 = new Pedido(156583, "Avenida del Sol 27");
        Pedido pedido7 = new Pedido(156584, "Paseo de la Luna 3");
        Pedido pedido8 = new Pedido(156585, "Rincón del Sabor 9");

        pedidoRepository.save(pedido2);
        pedidoRepository.save(pedido3);
        pedidoRepository.save(pedido4);
        pedidoRepository.save(pedido5);
        pedidoRepository.save(pedido6);
        pedidoRepository.save(pedido7);
        pedidoRepository.save(pedido8);
    }

    private void generateProducts() {
        Tipo tipo = new Tipo("Comestible","Producto comestible");
        tipoRepository.save(tipo);

        Producto productHummus = new Producto("Hummus", 4.50, tipo);
        Producto productFalafel = new Producto("Falafel", 6.75, tipo);
        Producto productBabaGanoush = new Producto("Baba Ganoush", 5.25, tipo);
        Producto productVeggieWrap = new Producto("Veggie Wrap", 8.50, tipo);
        Producto productChickenWrap = new Producto("Chicken Wrap", 7.25, tipo);
        Producto productBeyondBurger = new Producto("Beyond Burger", 29.50, tipo);
        Producto productSweetPotatoFries = new Producto("Sweet Potato Fries", 3.75, tipo);
        Producto productVeganCheese = new Producto("Vegan Cheese", 5.50, tipo);
        Producto productMushroomBurger = new Producto("Mushroom Burger", 24.25, tipo);
        Producto productGrilledTofu = new Producto("Grilled Tofu", 9.00, tipo);

        productRepository.save(productHummus);
        productRepository.save(productFalafel);
        productRepository.save(productBabaGanoush);
        productRepository.save(productVeggieWrap);
        productRepository.save(productChickenWrap);
        productRepository.save(productBeyondBurger);
        productRepository.save(productSweetPotatoFries);
        productRepository.save(productVeganCheese);
        productRepository.save(productMushroomBurger);
        productRepository.save(productGrilledTofu);
    }

    private void generateMenus() {
        Menu menu1 = new Menu("Especial Libanés", 32.0);
        Menu menu2 = new Menu("Vegetariano Delight", 18.5);
        Menu menu3 = new Menu("Combo Burger XL", 28.75);
        Menu menu4 = new Menu("Súper Veggie Mix", 22.0);
        Menu menu5 = new Menu("Cheese Lovers Burger", 26.5);

        menuRepository.save(menu1);
        menuRepository.save(menu2);
        menuRepository.save(menu3);
        menuRepository.save(menu4);
        menuRepository.save(menu5);
    }
}
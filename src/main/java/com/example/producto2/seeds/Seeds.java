package com.example.producto2.seeds;

import com.example.producto2.model.entity.Menu;
import com.example.producto2.model.entity.Producto;
import com.example.producto2.model.entity.Tipo;
import com.example.producto2.repository.MenuRepository;
import com.example.producto2.repository.ProductRepository;
import com.example.producto2.repository.TipoRepository;


public class Seeds {
    private MenuRepository menuRepository;
    private ProductRepository productRepository;
    private TipoRepository tipoRepository;

    public Seeds(MenuRepository menuRepository, ProductRepository productRepository, TipoRepository tipoRepository)  {
        this.menuRepository = menuRepository;
        this.productRepository = productRepository;
        this.tipoRepository = tipoRepository;
    }

    public void generateSeeds(){
        Menu menuLibanes = new Menu("Libanes", 30.5);
        Menu menuVeggie = new Menu("Veggie", 20);
        Menu menuBurguer = new Menu("Libanes", 25);
        menuRepository.save(menuLibanes);
        menuRepository.save(menuVeggie);
        menuRepository.save(menuBurguer);

        Tipo tipo = new Tipo("Comestible");
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
    }
}





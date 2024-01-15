package com.example.producto2;

import com.example.producto2.repository.MenuRepository;
import com.example.producto2.repository.ProductRepository;
import com.example.producto2.repository.TipoRepository;
import com.example.producto2.seeds.Seeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Producto2Application {

    @Autowired
    MenuRepository menuRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    TipoRepository tipoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Producto2Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        Seeds seeds = new Seeds(menuRepository, productRepository, tipoRepository);
        return runner -> {
            seeds.generateSeeds();
        };
    }

}

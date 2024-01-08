package com.example.producto2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "menus_has_productos")
public class Menu_has_producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu", nullable = false)
    private int menu_ID;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private int producto_ID;

    public int getMenu_ID() {
        return menu_ID;
    }

    public void setMenu_ID(int menu_ID) {
        this.menu_ID = menu_ID;
    }

    public int getProducto_ID() {
        return producto_ID;
    }

    public void setProducto_ID(int producto_ID) {
        this.producto_ID = producto_ID;
    }
}

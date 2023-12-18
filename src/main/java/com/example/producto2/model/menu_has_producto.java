package com.example.producto2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "menus_has_productos")
public class menu_has_producto {

    @Id
    private Integer id;

    @Column(name = "id_menu", nullable = false)
    private int menu_ID;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

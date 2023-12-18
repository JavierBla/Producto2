package com.example.producto2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name = "menus")
public class menu {
    @Id
    @Column(name = "id_menu")
    private int id;

    @Column(nullable = false)
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

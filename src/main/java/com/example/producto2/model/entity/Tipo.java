package com.example.producto2.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipos")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Integer id;

    @Column(name = "nombre",nullable = false, unique = true)
    private String nombre;

    @Column(name = "descrip", nullable = false)
    private String descripcion;

    public Tipo(String nombre, String descripcion) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
    }

    public Tipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

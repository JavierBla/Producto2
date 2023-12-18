package com.example.producto2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipos")
public class tipo {

    @Id
    @Column(name = "id_tipo")
    private Integer id;

    @Column(name = "nombre",nullable = false, unique = true)
    private String nombre;

    @Column(name = "descrip", nullable = false)
    private String descripcion;

    @Column(name = "id_producto", nullable = false)
    private int producto_ID;

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

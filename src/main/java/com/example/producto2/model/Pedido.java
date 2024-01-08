package com.example.producto2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    int id;
    @Column(name = "num_pedido", nullable = false)
    int numPedido;
    @Column(name = "direccion", nullable = false)
    String direccion;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

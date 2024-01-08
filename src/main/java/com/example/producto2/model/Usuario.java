package com.example.producto2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    int id;
    @Column(name = "nombre", nullable = false)
    String name;
    @Column(name = "apellidos", nullable = false)
    String apellidos;
    @Column(name = "email", nullable = false)
    String email;
    @Column(name = "telefono", nullable = false)
    int telefono;
    @ManyToOne()
    @JoinColumn(name = "id_pedido", nullable = false)
    Pedido pedido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}

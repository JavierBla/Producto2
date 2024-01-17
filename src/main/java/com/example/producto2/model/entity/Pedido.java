package com.example.producto2.model.entity;

import jakarta.persistence.*;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    Usuario usuario;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "pedido_productos",
            joinColumns = {@JoinColumn(name = "id_pedido")},
            inverseJoinColumns = {@JoinColumn(name = "id_producto")}
    )
    private List<Producto> productos;

    public Pedido(int numPedido, String direccion){
        this.numPedido = numPedido;
        this.direccion = direccion;
    }

    public Pedido() {

    }

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

    public List<Producto> getProductos() {
        return productos;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

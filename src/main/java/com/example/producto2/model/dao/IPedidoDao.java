package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Pedido;

import java.util.List;

public interface IPedidoDao {
    void save(Pedido pedido);

    Pedido findById(int id);

    List<Pedido> findAll();

    void delete(int id);

    void deleteAll();

    void update(Pedido pedido);
}

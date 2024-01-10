package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Pedido;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IPedidoDao {
    @Transactional
    void save(Pedido pedido);

    @Transactional
    Pedido findById(int id);

    @Transactional
    List<Pedido> findAll();
}

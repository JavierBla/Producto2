package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PedidoDaoImpl implements IPedidoDao{

    private final EntityManager manager;

    @Autowired
    public PedidoDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional
    public void save(Pedido pedido) {
        manager.persist(pedido);
    }

    @Override
    public Pedido findById(int id) {
        return manager.find(Pedido.class, id);
    }

    @Override
    public List<Pedido> findAll() {
        TypedQuery<Pedido> query = manager.createQuery("SELECT p FROM Pedido p", Pedido.class);
        return query.getResultList();
    }
}

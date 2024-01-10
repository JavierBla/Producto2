package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoDaoImpl implements ProductoDao {

    private EntityManager entityManager;

    public ProductoDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public void save(Producto producto) {
        entityManager.persist(producto);
    }

    @Override
    public Producto findByID(int id) {
        return entityManager.find(Producto.class, id);
    }

    @Override
    public List<Producto> findAll() {
        TypedQuery<Producto> typeProductos = entityManager.createQuery("from Producto", Producto.class);
        return typeProductos.getResultList();
    }
}

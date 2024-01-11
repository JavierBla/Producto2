package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductoDaoImpl implements ProductoDao {

    private EntityManager entityManager;

    public ProductoDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
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

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(findByID(id));
    }

    @Override
    @Transactional
    public void deleteAll() {
        List<Producto> productos = findAll();

        for (Producto producto : productos) {
            entityManager.remove(producto);
        }
    }

    @Override
    @Transactional
    public void update(Producto producto) {
        entityManager.merge(producto);
    }
}

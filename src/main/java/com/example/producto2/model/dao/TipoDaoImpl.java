package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Tipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TipoDaoImpl implements TipoDao{

    private EntityManager entityManager;

    @Autowired
    public TipoDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public void save(Tipo tipo) {
        entityManager.persist(tipo);
    }

    @Override
    public Tipo findByID(int id) {
        return entityManager.find(Tipo.class, id);
    }

    @Override
    public List<Tipo> findAll() {
        TypedQuery<Tipo> typeTipos = entityManager.createQuery("from Tipo", Tipo.class);
        return typeTipos.getResultList();
    }
}

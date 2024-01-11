package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Tipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TipoDaoImpl implements TipoDao{

    private EntityManager entityManager;

    @Autowired
    public TipoDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
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

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(findByID(id));
    }

    @Override
    @Transactional
    public void deleteAll() {
        List<Tipo> tipos = findAll();

        for (Tipo tipo : tipos) {
            entityManager.remove(tipo);
        }
    }

    @Override
    @Transactional
    public void update(Tipo tipo) {
        entityManager.merge(tipo);
    }
}

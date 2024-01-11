package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao{

    private final EntityManager manager;

    @Autowired
    public UsuarioDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        manager.persist(usuario);
    }

    @Override
    public Usuario findById(int id) {
        return manager.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> findAll() {
        TypedQuery<Usuario> query = manager.createQuery("SELECT u from Usuario u", Usuario.class);
        return query.getResultList();
    }

    @Override
    public Usuario findByRole(String role) {
        TypedQuery<Usuario> typedNadador = manager.createQuery("from Usuario where rolesAssociated=" + "'" + role + "'", Usuario.class);
        return typedNadador.getSingleResult();
    }

    @Override
    @Transactional
    public void delete(int id) {
        manager.remove(findById(id));
    }

    @Override
    @Transactional
    public void deleteAll() {
        List<Usuario> usuarios = findAll();

        for (Usuario usuario : usuarios) {
            manager.remove(usuario);
        }
    }

    @Override
    @Transactional
    public void update(Usuario usuarios) {
        manager.merge(usuarios);
    }
}

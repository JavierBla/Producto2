package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUsuarioDao {
    @Transactional
    void save(Usuario usuario);

    @Transactional
    Usuario findById(int id);

    @Transactional
    List<Usuario> findAll();
}

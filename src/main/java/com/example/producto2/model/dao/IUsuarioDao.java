package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUsuarioDao {
    void save(Usuario usuarios);

    Usuario findById(int id);

    List<Usuario> findAll();

    Usuario findByRole(String role);

    void delete(int id);

    void deleteAll();

    void update(Usuario usuarios);
}

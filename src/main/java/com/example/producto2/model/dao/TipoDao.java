package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Tipo;

import java.util.List;

public interface TipoDao {
    void save(Tipo tipo);
    Tipo findByID(int id);
    List<Tipo> findAll();
    void delete(int id);
    void deleteAll();
    void update(Tipo tipo);
}

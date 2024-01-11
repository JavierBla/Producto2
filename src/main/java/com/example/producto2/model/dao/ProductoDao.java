package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Producto;

import java.util.List;

public interface ProductoDao {
    void save(Producto producto);
    Producto findByID(int id);
    List<Producto> findAll();
    void delete(int id);
    void deleteAll();
    void update(Producto producto);
}

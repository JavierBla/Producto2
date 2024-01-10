package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Menu;
import com.example.producto2.model.entity.Producto;

import java.util.List;

public interface ProductoDao {
    void save(Producto producto);
    Producto findByID(int id);
    List<Producto> findAll();
}

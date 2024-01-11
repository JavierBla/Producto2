package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Menu;

import java.util.List;

public interface MenuDao {
    void save(Menu menu);

    Menu findByID(int id);

    List<Menu> findAll();

    void delete(int id);

    void deleteAll(int id);

    void update(Menu menu);
}

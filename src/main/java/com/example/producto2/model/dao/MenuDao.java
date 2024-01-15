package com.example.producto2.model.dao;

import com.example.producto2.model.entity.Menu;

import java.util.List;

public interface MenuDao {
    void save(Menu menu);

    Menu findByID(Long id);

    List<Menu> findAll();

    void delete(Long id);

    void deleteAll();

    void update(Menu menu);
}

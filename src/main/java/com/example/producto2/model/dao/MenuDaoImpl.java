package com.example.producto2.model.dao;
//https://github.com/psegarrac/producto2_PSP/tree/main
import com.example.producto2.model.entity.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MenuDaoImpl implements MenuDao {

    private EntityManager entityManager;

    public MenuDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Menu menu) {
        entityManager.persist(menu);
    }

    @Override
    public Menu findByID(Long id) {
        return entityManager.find(Menu.class, id);
    }

    @Override
    public List<Menu> findAll() {
        TypedQuery<Menu> typeMenus = entityManager.createQuery("from Menu", Menu.class);
        return typeMenus.getResultList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.remove(findByID(id));
    }

    @Override
    @Transactional
    public void deleteAll() {
        List<Menu> menus = findAll();

        for (Menu menu : menus) {
            entityManager.remove(menu);
        }
    }

    @Override
    @Transactional
    public void update(Menu menu) {
        entityManager.merge(menu);
    }
}

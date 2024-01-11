package com.example.producto2.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_has_usuario")
public class MenuUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    int menuID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    int usuarioID;

    public int getMenuID() {
        return menuID;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

}

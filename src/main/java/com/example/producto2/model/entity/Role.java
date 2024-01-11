package com.example.producto2.model.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role(){}

    @ManyToMany(mappedBy = "rolesAssociated", fetch = FetchType.LAZY)
    private Set<Usuario> usersAssociated = new LinkedHashSet<>();

    public Set<Usuario> getUsersAssociated() {
        return usersAssociated;
    }

    public void setUsersAssociated(Set<Usuario> usersAssociated) {
        this.usersAssociated = usersAssociated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

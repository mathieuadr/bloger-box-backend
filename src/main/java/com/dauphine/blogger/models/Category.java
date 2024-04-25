package com.dauphine.blogger.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name="id")
    private UUID id;
    @Column(name="name")
    private String name;

    public Category( String name) {
        name = name;

    }
    public Category(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        name = name;
    }
}

package com.dauphine.blogger.models;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Ou GenerationType.UUID si disponible
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;
    @Column(name="name")
    private String name;

    public Category( String name) {
        this.name = name;

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
        this.name = name;
    }
}

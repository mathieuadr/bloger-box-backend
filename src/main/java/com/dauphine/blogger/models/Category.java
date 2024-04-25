package com.dauphine.blogger.models;


import java.util.UUID;

public class Category {
    private UUID id;
    private String Nom;

    public Category(UUID id, String nom) {
        this.id = id;
        Nom = nom;

    }
    public Category(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
}

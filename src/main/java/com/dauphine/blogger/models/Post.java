package com.dauphine.blogger.models;

import com.dauphine.blogger.models.Category;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


public class Post {
    private UUID id;
    private String Title;
    private String texte;
    private LocalDateTime date_création;
    private Category categorie;

    public Post(UUID id,String title, String texte,  Category categorie) {
        this.id=id;
        this.Title = title;
        this.texte = texte;
        this.date_création = LocalDateTime.from(Instant.now());
        this.categorie = categorie;
    }
    public Post(){}

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public LocalDateTime getDate_création() {
        return date_création;
    }

    public void setDate_création(LocalDateTime date_création) {
        this.date_création = date_création;
    }

    public Category getCategorie() {
        return categorie;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCategorie(Category categorie) {
        this.categorie = categorie;
    }
}

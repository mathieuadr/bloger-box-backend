package com.dauphine.blogger.models;

import com.dauphine.blogger.models.Category;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="post")
public class Post {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "title")
    private String Title;
    @Column(name = "content")
    private String Content;    @Id
    @Column(name = "created_date")
    private LocalDateTime date_création;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categorie;

    public Post(String title, String Content,  Category categorie) {
        this.Title = title;
        this.Content = Content;
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

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
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

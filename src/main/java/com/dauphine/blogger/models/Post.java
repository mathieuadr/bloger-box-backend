package com.dauphine.blogger.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Ou GenerationType.UUID si disponible
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;
    @Column(name = "title")
    private String Title;
    @Column(name = "content")
    private String Content;
    @Column(name = "created_date")
    private LocalDateTime date_création;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Post(String title, String Content,  Category category) {
        this.Title = title;
        this.Content = Content;
        this.date_création = LocalDateTime.now();
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

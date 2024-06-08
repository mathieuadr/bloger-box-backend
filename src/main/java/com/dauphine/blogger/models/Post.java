package com.dauphine.blogger.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "post")
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
    @JsonFormat(pattern ="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime created_date;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Post(String title, String Content, Category category) {
        this.Title = title;
        this.Content = Content;
        this.created_date = LocalDateTime.now();
        this.category = category;
    }

    public Post() {
    }

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

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime date_création) {
        this.created_date = date_création;
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

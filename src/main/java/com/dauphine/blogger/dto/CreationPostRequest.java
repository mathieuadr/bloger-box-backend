package com.dauphine.blogger.dto;

import com.dauphine.blogger.models.Category;

import java.time.LocalDateTime;

public class CreationPostRequest {
    private String Title;
    private String content;

    private LocalDateTime date_creation;
    private Category category;

    public void setTitle(String title) {
        Title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate_creation(LocalDateTime date_creation) {
        this.date_creation = date_creation;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return Title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDate_creation() {
        return date_creation;
    }

    public Category getCategory() {
        return category;
    }
}


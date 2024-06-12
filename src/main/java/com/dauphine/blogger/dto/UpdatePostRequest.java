package com.dauphine.blogger.dto;

import com.dauphine.blogger.models.Category;

import java.util.UUID;

public class UpdatePostRequest {
    private String Title;
    private String content;



    private UUID id;
    private Category category;

    public void setTitle(String title) {
        Title = title;
    }

    public void setContent(String content) {
        this.content = content;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }
}

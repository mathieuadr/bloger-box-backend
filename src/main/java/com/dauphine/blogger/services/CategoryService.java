package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface CategoryService {
    List<Category> getAll();

    Category getByID(UUID id);

    Category Create(String name);

    Category update(UUID id,String name);
    Category deleteByID(UUID id);
}

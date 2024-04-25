package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServicesImp implements CategoryService {
    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public Category getByID(UUID id) {
        return null;
    }

    @Override
    public Category Create(String name) {
        return null;
    }

    @Override
    public Category update(UUID id, String name) {
        return null;
    }

    @Override
    public Category deleteByID(UUID id) {

        return null;
    }
}

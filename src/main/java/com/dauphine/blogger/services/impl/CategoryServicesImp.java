package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.repositories.CategoryRepository;
import com.dauphine.blogger.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServicesImp implements CategoryService {
    private final CategoryRepository repository;

    public CategoryServicesImp(CategoryRepository repository){
        this.repository=repository;
    }
    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category getByID(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Category Create(String name) {
        Category cat = new Category(name);
        return repository.save(cat);
    }

    @Override
    public Category update(UUID id, String name) {

        Category cat = getByID(id);
        if (cat==null){
            return null;
        }
        cat.setname(name);
        return repository.save(cat);
    }
    @Override
    public Boolean deleteByID(UUID id) {
        repository.deleteById(id);
        return true;
    }
}

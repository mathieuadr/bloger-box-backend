package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.ExceptionHandler.Exception.CategoryNotFoundByIdException;
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
    public Category getByID(UUID id) throws CategoryNotFoundByIdException {
        //TEST 01 : Get with valid ID
        //TEST 02 : Get with invalid ID
        return repository.findById(id).orElseThrow(()-> new CategoryNotFoundByIdException(id));
    }

    @Override
    public Category Create(String name) {
        // TEST 01 : Name pas pris
        // TEST 02 : Name deja pris
        Category cat = new Category(name);
        return repository.save(cat);
    }

    @Override
    public Category update(UUID id, String name) throws CategoryNotFoundByIdException {

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

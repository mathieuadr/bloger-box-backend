package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.ExceptionHandler.Exception.CategoryExistingNameException;
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
    public void CheckName(String Name) throws CategoryExistingNameException{
        if (repository.findByName(Name) != null) {
            throw new CategoryExistingNameException(Name);
        }
    };

    @Override
    public Category Create(String name) throws CategoryExistingNameException {
        // TEST 01 : Name pas pris
        // TEST 02 : Name deja pris
        CheckName(name);
        Category cat = new Category(name);
        return repository.save(cat);
    }

    @Override
    public Category update(UUID id, String name) throws CategoryNotFoundByIdException,CategoryExistingNameException {
        Category cat = getByID(id);
        CheckName(name);
        cat.setname(name);
        return repository.save(cat);
    }
    @Override
    public Boolean deleteByID(UUID id) throws CategoryNotFoundByIdException{
        getByID(id);
        repository.deleteById(id);
        return true;
    }
}

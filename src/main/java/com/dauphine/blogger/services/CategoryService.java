package com.dauphine.blogger.services;

import com.dauphine.blogger.ExceptionHandler.Exception.CategoryExistingNameException;
import com.dauphine.blogger.ExceptionHandler.Exception.CategoryNotFoundByIdException;
import com.dauphine.blogger.models.Category;

import java.util.List;
import java.util.UUID;


public interface CategoryService {
    List<Category> getAll();

    Category getByID(UUID id) throws CategoryNotFoundByIdException;
    void CheckName(String Name) throws CategoryExistingNameException;
    Category Create(String name) throws CategoryExistingNameException;

    Category update (UUID id,String name)throws CategoryNotFoundByIdException,CategoryExistingNameException;
    Boolean deleteByID(UUID id) throws CategoryNotFoundByIdException;
}

package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.ExceptionHandler.Exception.CategoryExistingNameException;
import com.dauphine.blogger.ExceptionHandler.Exception.CategoryNotFoundByIdException;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.repositories.CategoryRepository;
import com.dauphine.blogger.services.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    private CategoryRepository CategoryRepository;
    private CategoryService CategoryService;

    @BeforeEach
    public void setUp() {
        CategoryRepository = mock(CategoryRepository.class);
        CategoryService = new CategoryServicesImp(CategoryRepository);
    }
    @Test
    void shouldReturnCategoryWhenIdExist() throws CategoryNotFoundByIdException {

        CategoryRepository categoryRepository = mock(CategoryRepository.class);
        CategoryServicesImp categoryService = new CategoryServicesImp(categoryRepository);
        UUID id= UUID.randomUUID();
        Category category = new Category("Test");
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));

        Category actual = categoryService.getByID(id);

        assertEquals(category,actual);
    }

    @Test
    void shouldThrowExceptionWhenIdDoesNotExist(){

        CategoryRepository categoryRepository = mock(CategoryRepository.class);
        CategoryServicesImp categoryService = new CategoryServicesImp(categoryRepository);
        UUID id= UUID.randomUUID();
        Category category = new Category("Test");
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        CategoryNotFoundByIdException exception=assertThrows(
                CategoryNotFoundByIdException.class,()->categoryService.getByID(id));

        assertEquals("La Catégorie "+id+" n'existe pas",exception.getMessage());
    }



    //test d'exercice pour vérifier la bonne compréhension des différents éléments
    @Test
    void shouldThrowExceptionWhenNameAlreadyExists(){
        CategoryRepository categoryRepository = mock(CategoryRepository.class);
        CategoryServicesImp categoryService = new CategoryServicesImp(categoryRepository);
        UUID id= UUID.randomUUID();
        String name="Test";
        Category cat = new Category(name);
        when(categoryRepository.findByName(name)).thenReturn(cat);
        CategoryExistingNameException exception=assertThrows(
                CategoryExistingNameException.class,()->categoryService.CheckName(name));

        assertEquals("La category "+name+" existe deja",exception.getMessage());
    }
}

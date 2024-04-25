package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationCategoryRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(
        name="Categories Controller API",
        description = "Permit to control the categories"
)
@RequestMapping("/v1/categories")
public class CategoryController {
    private final CategoryService service;


    public CategoryController(CategoryService services){
            this.service=services;
    }


    @GetMapping("")
    public List<Category> getallcategories(){
        return service.getAll();
    };

    @GetMapping("/{id}")
    public Category GetIdCategorie(@PathVariable UUID id){
        return service.getByID(id);
    }

    @PostMapping("/{name}")
    public Category CreateCategory(@PathVariable String name, @RequestBody CreationCategoryRequest Category){
        return service.Create(Category.getName());
    }

    @PutMapping("/{name}/{id}")
    public Category UpdateCategory(@PathVariable String name,@PathVariable UUID id){
        return service.update(id,name);
    }
    @DeleteMapping("/{id}")
    public Category deleteCategory(@PathVariable UUID id){
        return service.deleteByID(id);
    }

}

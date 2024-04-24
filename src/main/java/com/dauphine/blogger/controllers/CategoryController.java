package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationCategoryRequest;
import com.dauphine.blogger.models.Category;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@Tag(
        name="Categories Controller API",
        description = "Permit to control the categories"
)
@RequestMapping("/v1/categories")
public class CategoryController {
    private final ArrayList<Category> categories;

    public CategoryController(){
        categories=new ArrayList<>();
        categories.add(new Category(UUID.randomUUID(),"first CAT"));
        categories.add(new Category(UUID.randomUUID(),"Second CAT"));
        categories.add(new Category(UUID.randomUUID(),"Third CAT"));
    }


    @GetMapping("")
    public ArrayList<Category> getallcategories(){
        return categories;
    };

    @GetMapping("/{id}")
    public Category GetIdCategorie(@PathVariable UUID id){
        return GetidCategories(id);
    }

    @PostMapping("/{name}")
    public void CreateCategory(@PathVariable String name){
        Category a= new Category();
        a.setNom(name);
        a.setId(UUID.randomUUID());
        categories.add(a);
    }

    @PutMapping("/{name}/{id}")
    public void UpdateCategory(@PathVariable String name,@PathVariable UUID id){
        Category a = GetidCategories(id);
        if(a!=null){
            a.setNom(name);
        }
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable UUID id){
        Category a = GetidCategories(id);
        if(a!=null){
            categories.remove(a);
        }
    }

    public Category GetidCategories(UUID id){
        for(Category a :categories){
            if(a.getId().equals(id)){
                return a;
            }
        }
        return null;
    }
}

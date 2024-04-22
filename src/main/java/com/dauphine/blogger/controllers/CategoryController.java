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
    private final ArrayList<Category> categories=new ArrayList<>();


    @GetMapping("")
    public ArrayList<Category> getallcategories(){
        return categories;
    };

    @GetMapping("/{id}")
    public String GetIdCategorie(@PathVariable UUID id){
        return "";
    }

    @PostMapping("/{name}")
    public void CreateCategory(@PathVariable String name){
        Category a= new Category();
        a.setNom(name);
        a.setId(UUID.randomUUID());
    }

    @PutMapping("/{name}/{id}")
    public void UpdateCategory(@PathVariable String name,@PathVariable UUID id){

    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable UUID id){

    }
}

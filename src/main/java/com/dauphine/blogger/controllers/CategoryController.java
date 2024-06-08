package com.dauphine.blogger.controllers;

import com.dauphine.blogger.ExceptionHandler.Exception.CategoryNotFoundByIdException;
import com.dauphine.blogger.dto.CreationCategoryRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Categories Controller API", description = "Permit to control the categories")
@RequestMapping("/v1/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service){
        this.service = service;
    }

    @GetMapping("")
    @Operation(summary = "Get all categories", description = "Retrieve a list of all categories")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of categories",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Category.class)))
    public List<Category> getallcategories() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a category by ID", description = "Retrieve a category by its unique identifier")

    @ApiResponse(responseCode = "200", description = "Category found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Category.class)))
    public ResponseEntity<Category> getIdCategory(@PathVariable UUID id) throws CategoryNotFoundByIdException {
        Category cat=service.getByID(id);
        return ResponseEntity.ok(cat);
    }

    @PostMapping("")
    @Operation(summary = "Create a new category", description = "Creates a new category with the given details")
    @ApiResponse(responseCode = "201", description = "Category created",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Category.class)))
    public Category createCategory(@RequestBody CreationCategoryRequest category) {
        return service.Create(category.getName());
    }

    @PutMapping("/{id}/{name}")
    @Operation(summary = "Update a category", description = "Updates an existing category with a new name")

    @ApiResponse(responseCode = "200", description = "Category updated",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Category.class)))
    public Category updateCategory(@PathVariable UUID id, @PathVariable String name) throws CategoryNotFoundByIdException{
        return service.update(id, name);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a category", description = "Deletes a category by its ID")
        @ApiResponse(responseCode = "200", description = "Category deleted",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Boolean.class)))
    public Boolean deleteCategory(@PathVariable UUID id) throws CategoryNotFoundByIdException{
        return service.deleteByID(id);
    }
}

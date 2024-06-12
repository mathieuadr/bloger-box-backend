package com.dauphine.blogger.controllers;

import com.dauphine.blogger.ExceptionHandler.Exception.CategoryExistingNameException;
import com.dauphine.blogger.ExceptionHandler.Exception.CategoryNotFoundByIdException;
import com.dauphine.blogger.ExceptionHandler.Exception.PostExistingNameException;
import com.dauphine.blogger.ExceptionHandler.Exception.PostNotFoundByIdException;
import com.dauphine.blogger.dto.CreationPostRequest;
import com.dauphine.blogger.dto.UpdatePostRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostServices;
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
@Tag(name="Post Controller API", description = "Permit to control the Post")
@RequestMapping("/v1/posts")
public class PostController {
    private final PostServices posts;

    public PostController(PostServices posts){
        this.posts = posts;
    }

    @GetMapping("/GetALL")
    @Operation(summary = "Get all posts", description = "Retrieve a list of all posts")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of posts",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Post.class)))
    public List<Post> getAllPost() {
        return posts.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get posts by post ID", description = "Retrieve all posts associated with a category ID")

    @ApiResponse(responseCode = "200", description = "Posts found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Post.class)))
    public ResponseEntity<Post> getId(@PathVariable UUID id) throws PostNotFoundByIdException{
        return ResponseEntity.ok(posts.getById(id));
    }

    @PostMapping("/Create")
    @Operation(summary = "Create a new post", description = "Creates a new post with the provided name, content, and category ID")
    @ApiResponse(responseCode = "201", description = "Post created",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Post.class)))
    public ResponseEntity<Post> createPost(@RequestBody CreationPostRequest post) throws CategoryNotFoundByIdException, PostExistingNameException, CategoryExistingNameException {
        return ResponseEntity.ok(posts.create(post.getTitle(), post.getContent(), post.getCategory().getId()));
    }

    @PutMapping("/update")
    @Operation(summary = "Update a post", description = "Updates an existing post with a new name and content")
    @ApiResponse(responseCode = "200", description = "Post updated",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Post.class)))
    public ResponseEntity<Post> updatePost( @RequestBody UpdatePostRequest post) throws CategoryNotFoundByIdException,PostNotFoundByIdException, PostExistingNameException, CategoryExistingNameException {
        return ResponseEntity.ok(posts.update(post.getId(), post.getTitle(),post.getCategory(), post.getContent()));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a post", description = "Deletes a post by its ID")
    @ApiResponse(responseCode = "200", description = "Post deleted",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Boolean.class)))
    public ResponseEntity<Boolean> deletePost(@PathVariable UUID id) throws PostNotFoundByIdException{
        return ResponseEntity.ok(posts.deleteByID(id));
    }

    @GetMapping("/by-name/{categoryName}")
    @Operation(summary = "Get posts by category name", description = "Retrieve all posts associated with a category name")
    @ApiResponse(responseCode = "200", description = "Posts found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Post.class)))
    public List<Post> getPostsByCategoryName(@PathVariable("categoryName") String categoryName) {
        return posts.getAllByCategoryName(categoryName);
    }
}

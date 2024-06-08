package com.dauphine.blogger.controllers;

import com.dauphine.blogger.ExceptionHandler.Exception.CategoryNotFoundByIdException;
import com.dauphine.blogger.ExceptionHandler.Exception.PostNotFoundByIdException;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @GetMapping("")
    @Operation(summary = "Get all posts", description = "Retrieve a list of all posts")
    @ApiResponse(responseCode = "200", description = "Successful retrieval of posts",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Post.class)))
    public List<Post> getallcategories() {
        return posts.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get posts by post ID", description = "Retrieve all posts associated with a category ID")

    @ApiResponse(responseCode = "200", description = "Posts found",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Post.class)))
    public Post getId(@PathVariable UUID id) throws PostNotFoundByIdException{
        return posts.getById(id);
    }

    @PostMapping("")
    @Operation(summary = "Create a new post", description = "Creates a new post with the provided name, content, and category ID")
    @ApiResponse(responseCode = "201", description = "Post created",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Post.class)))
    public Post createPost(@RequestBody Post post) throws CategoryNotFoundByIdException {
        return posts.create(post.getTitle(), post.getContent(), post.getCategory().getId());
    }

    @PutMapping("/{id}/{Title}/{content}/{category}")
    @Operation(summary = "Update a post", description = "Updates an existing post with a new name and content")
    @ApiResponse(responseCode = "200", description = "Post updated",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Post.class)))
    public Post updatePost(@PathVariable UUID id, @RequestBody Post post) throws PostNotFoundByIdException {
        return posts.update(id, post.getTitle(), post.getContent());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a post", description = "Deletes a post by its ID")
    @ApiResponse(responseCode = "200", description = "Post deleted",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Boolean.class)))
    public Boolean deletePost(@PathVariable UUID id) throws PostNotFoundByIdException{
        return posts.deleteByID(id);
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

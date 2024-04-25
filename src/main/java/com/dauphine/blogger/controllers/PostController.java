package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@RestController
@Tag(
        name="Post Controller API",
        description = "Permit to control the Post"
)
@RequestMapping("/v1/posts")
public class PostController {
    private final PostServices Posts;

    public PostController(PostServices Posts){
        this.Posts=Posts;

    }




    @GetMapping("")
    public List<Post> getallcategories(){

        return Posts.getAll();
    };

    @GetMapping("/{id}")
    public List<Post> GetIdCategorie(@PathVariable UUID id){
        return Posts.getAllByCategoryID(id);
    }

    @PostMapping("/{name}/{content}")
    public Post CreatePost(@PathVariable String name,@PathVariable String content){
       return Posts.create(name,content,UUID.randomUUID());

    }

    @PutMapping("/{name}/{id}/{content}")
    public Post UpdateCategory(@PathVariable String name,@PathVariable UUID id,@PathVariable String content){
        return Posts.update(id,name,content);

    }
    @DeleteMapping("/{id}")
    public Boolean deleteCategory(@PathVariable UUID id){
        return Posts.deleteByID(id);
    }



}

package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Post;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

@RestController
@Tag(
        name="Post Controller API",
        description = "Permit to control the Post"
)
@RequestMapping("/v1/posts")
public class PostController {
    private final ArrayList<Post> Posts=new ArrayList<>();


    @GetMapping("")
    public ArrayList<Post> getallcategories(){
        return Posts;
    };

    @GetMapping("/{id}")
    public String GetIdCategorie(@PathVariable UUID id){
        return "";
    }

    @PostMapping("/{name}")
    public void CreateCategory(@PathVariable String name){
        Post a= new Post();

    }

    @PutMapping("/{name}/{id}")
    public void UpdateCategory(@PathVariable String name,@PathVariable UUID id){

    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable UUID id){

    }
}

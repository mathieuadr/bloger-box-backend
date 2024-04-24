package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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
    private final ArrayList<Post> Posts;

    public PostController(){
        Posts=new ArrayList<>();
        Posts.add(new Post(UUID.randomUUID(),"Post 1","Mon premier post", new Category(UUID.randomUUID(),"1")));
        Posts.add(new Post(UUID.randomUUID(),"Post 2","Mon premier post", new Category(UUID.randomUUID(),"2")));
    }




    @GetMapping("")
    public ArrayList<Post> getallcategories(){
        return Posts;
    };

    @GetMapping("/{id}")
    public String GetIdCategorie(@PathVariable int id){
        return "";
    }

    @PostMapping("/{name}")
    public void CreateCategory(@PathVariable String name){
        Post a= new Post();

    }

    @PutMapping("/{name}/{id}")
    public void UpdateCategory(@PathVariable String name,@PathVariable int id){

    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){

    }


    public Post getIdControllers(UUID id){
            for(Post a :Posts){
                if(a.getId().equals(id)){
                    return a;
                }
            }
            return null;
        }
    }
}

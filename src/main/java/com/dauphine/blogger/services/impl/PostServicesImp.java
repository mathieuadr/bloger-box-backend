package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.repositories.CategoryRepository;
import com.dauphine.blogger.repositories.PostRepository;
import com.dauphine.blogger.services.PostServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServicesImp implements PostServices {

    private final PostRepository repository;
    private final CategoryRepository repositoryCat;

    public PostServicesImp(PostRepository repository,CategoryRepository repositoryCat){
        this.repository=repository;
        this.repositoryCat=repositoryCat;
    }
    @Override
    public List<Post> getAllByCategoryID(UUID Categoryid) {
        return repository.findAllByCategoryId(Categoryid);
    }

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }

    @Override
    public Post getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Post create(String title, String Content, UUID CategoryId) {
        Category category=repositoryCat.findById(CategoryId).orElse(null);
        Post post = new Post(title,Content,category);
        return repository.save(post);
    }

    @Override
    public Post update(UUID id, String Title, String Content) {
        Post post =repository.findById(id).orElse(null);
        if (post==null){
            return null;
        }
        post.setTitle(Title);
        post.setContent(Content);
        return repository.save(post);
    }

    @Override
    public Boolean deleteByID(UUID id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Post> getAllByCategoryName(String name) {
        return repository.findAllByCategoryName(name);
    }
}

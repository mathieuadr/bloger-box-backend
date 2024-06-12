package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.ExceptionHandler.Exception.CategoryNotFoundByIdException;
import com.dauphine.blogger.ExceptionHandler.Exception.PostExistingNameException;
import com.dauphine.blogger.ExceptionHandler.Exception.PostNotFoundByIdException;
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
    public List<Post> getAllByCategoryID(UUID Categoryid)throws CategoryNotFoundByIdException {
        return repository.findAllByCategoryId(Categoryid);
    }

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }

    @Override
    public Post getById(UUID id) throws PostNotFoundByIdException {
        return repository.findById(id).orElseThrow(()->new PostNotFoundByIdException(id));
    }

    @Override
    public void CheckTitle(String title) throws PostExistingNameException {
        Post post = repository.findByTitle(title);
        if(post!=null){
            throw new PostExistingNameException(title);
        }

    }

    @Override
    public Post create(String title, String Content, UUID CategoryId) throws CategoryNotFoundByIdException,PostExistingNameException {
        CheckTitle(title);
        Category category=repositoryCat.findById(CategoryId).orElseThrow(()-> new CategoryNotFoundByIdException(CategoryId));
        Post post = new Post(title,Content,category);
        return repository.save(post);
    }

    @Override
    public Post update(UUID id,String title, Category Cat, String Content) throws PostNotFoundByIdException,PostExistingNameException,CategoryNotFoundByIdException {
        CheckTitle(title);
        Category category=repositoryCat.findById(Cat.getId()).orElseThrow(()-> new CategoryNotFoundByIdException(Cat.getId()));
        Post post =getById(id);
        post.setCategory(Cat);
        post.setTitle(title);
        post.setContent(Content);
        return repository.save(post);
    }

    @Override
    public Boolean deleteByID(UUID id) throws PostNotFoundByIdException{
        getById(id);
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Post> getAllByCategoryName(String name) {
        return repository.findAllByCategoryName(name);
    }
}

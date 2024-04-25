package com.dauphine.blogger.services.impl;

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

    public PostServicesImp(PostRepository rep){
        this.repository=rep;
    }
    @Override
    public List<Post> getAllByCategoryID(UUID Categoryid) {
        return repository.fi();
    }

    @Override
    public List<Post> getAll() {
        return null;
    }

    @Override
    public Post getById(UUID id) {
        return null;
    }

    @Override
    public Post create(String title, String Content, UUID CategoryId) {
        return null;
    }

    @Override
    public Post update(UUID id, String Title, String Content) {
        return null;
    }

    @Override
    public Boolean deleteByID(UUID id) {
        return null;
    }
}

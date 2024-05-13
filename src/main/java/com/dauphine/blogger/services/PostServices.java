package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;



public interface PostServices {
    List<Post> getAllByCategoryID(UUID Categoryid);


    List<Post>getAll();

    Post getById(UUID id);

    Post create(String title,String Content, UUID CategoryId);

    Post update(UUID id, String Title, String Content);

    Boolean deleteByID(UUID id);

    List<Post> getAllByCategorieName(String name);
}

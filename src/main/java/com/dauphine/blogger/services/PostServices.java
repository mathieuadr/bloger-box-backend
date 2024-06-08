package com.dauphine.blogger.services;

import com.dauphine.blogger.ExceptionHandler.Exception.CategoryNotFoundByIdException;
import com.dauphine.blogger.ExceptionHandler.Exception.PostExistingNameException;
import com.dauphine.blogger.ExceptionHandler.Exception.PostNotFoundByIdException;
import com.dauphine.blogger.models.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;



public interface PostServices {
    List<Post> getAllByCategoryID(UUID Categoryid)throws CategoryNotFoundByIdException;


    List<Post>getAll();

    Post getById(UUID id) throws PostNotFoundByIdException;

    Post create(String title,String Content, UUID CategoryId) throws CategoryNotFoundByIdException;

    Post update (UUID id, String Title, String Content) throws PostNotFoundByIdException;

    Boolean deleteByID(UUID id);

    List<Post> getAllByCategoryName(String name);
}

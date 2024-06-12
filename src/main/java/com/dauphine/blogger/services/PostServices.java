package com.dauphine.blogger.services;

import com.dauphine.blogger.ExceptionHandler.Exception.CategoryExistingNameException;
import com.dauphine.blogger.ExceptionHandler.Exception.CategoryNotFoundByIdException;
import com.dauphine.blogger.ExceptionHandler.Exception.PostExistingNameException;
import com.dauphine.blogger.ExceptionHandler.Exception.PostNotFoundByIdException;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;



public interface PostServices {
    List<Post> getAllByCategoryID(UUID Categoryid)throws CategoryNotFoundByIdException;


    List<Post>getAll();

    Post getById(UUID id) throws PostNotFoundByIdException;
    void CheckTitle(String title)throws PostExistingNameException;
    Post create(String title,String Content, UUID CategoryId) throws PostExistingNameException,CategoryNotFoundByIdException, CategoryExistingNameException;

    Post update (UUID id,String title, Category cat, String Content) throws CategoryNotFoundByIdException,PostNotFoundByIdException,PostExistingNameException,CategoryExistingNameException;

    Boolean deleteByID(UUID id)throws PostNotFoundByIdException;

    List<Post> getAllByCategoryName(String name) ;
}

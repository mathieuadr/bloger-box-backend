package com.dauphine.blogger.ExceptionHandler.Exception;


import java.util.UUID;

public class CategoryNotFoundByIdException extends Exception {

    public CategoryNotFoundByIdException(UUID id) {
        super("La Catégorie "+id+" n'existe pas");
    }

    public CategoryNotFoundByIdException(String message, Throwable cause) {
        super(message, cause);
    }
}


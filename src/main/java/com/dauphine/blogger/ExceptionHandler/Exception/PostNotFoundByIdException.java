package com.dauphine.blogger.ExceptionHandler.Exception;

import java.util.UUID;

public class PostNotFoundByIdException extends Exception {

    public PostNotFoundByIdException(UUID id) {
        super("Le post "+id+" n'existe pas");
    }

    public PostNotFoundByIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
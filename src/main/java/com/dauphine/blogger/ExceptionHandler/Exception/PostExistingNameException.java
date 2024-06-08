package com.dauphine.blogger.ExceptionHandler.Exception;

public class PostExistingNameException extends Exception{
    public PostExistingNameException(String Name){
        super("Le post "+Name+" existe deja");
    }
}

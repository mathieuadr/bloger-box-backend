package com.dauphine.blogger.ExceptionHandler.Exception;

public class CategoryExistingNameException extends Exception{
    public CategoryExistingNameException(String Name){
        super("La category "+Name+" existe deja");
    }
}

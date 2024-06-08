package com.dauphine.blogger.ExceptionHandler;

import com.dauphine.blogger.ExceptionHandler.Exception.CategoryExistingNameException;
import com.dauphine.blogger.ExceptionHandler.Exception.CategoryNotFoundByIdException;
import com.dauphine.blogger.ExceptionHandler.Exception.PostExistingNameException;
import com.dauphine.blogger.ExceptionHandler.Exception.PostNotFoundByIdException;
import com.dauphine.blogger.models.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static final Logger logger= LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler({
            CategoryNotFoundByIdException.class,
            PostNotFoundByIdException.class
    })
    public ResponseEntity<String> handleNotFoundException(Exception ex){
        logger.warn("[NOT FOUND] {}",  ex.getMessage());
        return ResponseEntity.status(403).body(ex.getMessage());
    }

    @ExceptionHandler({
            CategoryExistingNameException.class,
            PostExistingNameException.class
    })
    public ResponseEntity<String> handleNameException(Exception ex){
        logger.warn("[Existing Name] {}",  ex.getMessage());
        return ResponseEntity.status(402).body(ex.getMessage());
    }



}

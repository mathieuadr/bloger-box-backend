package com.dauphine.blogger.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(
        name="Hello world API",
        description = "My first hello world endpoints"
)
public class HelloWorldController {
    @GetMapping("hello-world")
    public String helloworld(){
        return "hello World";
    }
    //Path Variable
    @GetMapping("hello/{name}")
    @Operation(summary = "Hello by name endpoint",
            description = "Return 'Hello{name}' by path variable"

    )
    public String Helloname(@Parameter(description = "Name to greet") @PathVariable String name){
        return "Hello "+name;
    }
}

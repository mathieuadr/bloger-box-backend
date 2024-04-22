package com.dauphine.blogger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("hello-world")
    public String helloworld(){
        return "hello World";
    }
    //Path Variable
    @GetMapping("hello/{name}")
    public String Helloname(@PathVariable String name){
        return "Hello "+name;
    }
}

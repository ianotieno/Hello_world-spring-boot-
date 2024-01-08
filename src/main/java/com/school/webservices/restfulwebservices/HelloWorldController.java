package com.school.webservices.restfulwebservices;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Rest Api
@RestController
public class HelloWorldController {
    @GetMapping( path = "/hello-world")
    public  String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "hello-world-bean")
    public helloworldbean helloworldbean(){
        return new helloworldbean("hello wolrd bean");
    }
    @GetMapping(path = "hello-world/path-variable/{name}")
    public helloworldbean helloworldPathVariable(@PathVariable String name){
        return new helloworldbean(String.format("hello wolrd,%s ",name));
    }
}

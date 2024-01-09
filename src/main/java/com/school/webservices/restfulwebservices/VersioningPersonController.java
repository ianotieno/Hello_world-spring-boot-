package com.school.webservices.restfulwebservices;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping(path = "/v1/person")
    public  Person getFirstP(){
        return new Person ("Sharon Gwen");
    }
}

package com.school.webservices.restfulwebservices;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping(path = "/v1/person")
    public  Person getFirstP(){
        return new Person ("Sharon Gwen");
    }
    @GetMapping(path = "/v2/person")
    public PersonV2 getSecond(){
        return  new PersonV2(new Name("Brendah","Mogaka"));
    }
    @GetMapping(path = "/person", params = "version=1")
     public  Person getFirstVOfPerson(){
        return new Person("Mercy Kabati");
    }
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getVersion(){
        return new PersonV2(new Name("Stella","mwangi"));
    }
}

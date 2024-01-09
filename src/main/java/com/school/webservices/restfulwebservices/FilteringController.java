package com.school.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping(path ="/filter" )
     public somebean filter(){
         return new somebean("value1","value2","value3");
     }
    @GetMapping(path ="/filter-list" )
    public List<somebean > filter1(){
        return Arrays.asList(new somebean("value1","value2","value3"),
                new somebean("value4","value5","value6")
                ) ;
    }
}

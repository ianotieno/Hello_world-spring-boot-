package com.school.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
     public somebean filter(){
         return new somebean("value1","value2","value3");
     }
}

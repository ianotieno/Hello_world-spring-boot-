package com.school.webservices.restfulwebservices;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping(path ="/filter" )
     public MappingJacksonValue filter(){
         somebean SomeBean= new somebean("value1","value2","value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(SomeBean);
        FilterProvider filters = new SimpleFilterProvider();
        mappingJacksonValue.setFilters(filters);
         return mappingJacksonValue ;
     }
    @GetMapping(path ="/filter-list" )
    public List<somebean > filter1(){
        return Arrays.asList(new somebean("value1","value2","value3"),
                new somebean("value4","value5","value6")
                ) ;
    }
}

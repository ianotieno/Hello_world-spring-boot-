package com.school.webservices.restfulwebservices;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
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

        SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);
         return mappingJacksonValue ;
     }
    @GetMapping(path ="/filter-list" )
    public MappingJacksonValue filter1(){
        List<somebean> list = Arrays.asList(new somebean("value1", "value2", "value3"),
                new somebean("value4", "value5", "value6")
        );
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("field1");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return  mappingJacksonValue;
    }
}

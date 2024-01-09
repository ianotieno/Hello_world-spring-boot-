package com.school.webservices.restfulwebservices;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//Rest Api
@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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
    @GetMapping(path = "/hello-world-inter")
    public  String helloWorldInter(){
        Locale locale = LocaleContextHolder.getLocale();
      return   messageSource.getMessage("good.morning.message",null,"Default message",locale);

    }
}

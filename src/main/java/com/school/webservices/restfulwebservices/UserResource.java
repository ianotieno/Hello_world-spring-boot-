package com.school.webservices.restfulwebservices;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import  jakarta.validation.Valid;
@RestController
public class UserResource {
    private final UserDaoService  userDaoService;


    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return  userDaoService.findAll();

    }
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = userDaoService.findOne(id);
        if(user==null)
            throw  new UserNotFoundException("id:"+id);

         return  user;
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.deleteById(id);

    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
   User user1=  userDaoService.save(user);
    URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user1.getId()).toUri();
    return ResponseEntity.created(location).build();
    }
 @GetMapping(path = "/hello-world-inter")
    public  String helloWorldInter(){
        return  "Hello world ";
 }
}

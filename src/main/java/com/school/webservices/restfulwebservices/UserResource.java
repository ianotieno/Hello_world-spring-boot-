package com.school.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return  userDaoService.findOne(id);

    }
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
    userDaoService.save(user);
    }

}
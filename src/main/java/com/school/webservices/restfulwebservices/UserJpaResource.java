package com.school.webservices.restfulwebservices;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {
    private final UserDaoService  userDaoService;
   private final UserRepository userRepository;

    public UserJpaResource(UserDaoService userDaoService, UserRepository userRepository) {
        this.userDaoService = userDaoService;
        this.userRepository = userRepository;
    }
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return  userRepository.findAll();

    }
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User user1=  userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User > retrieveUser(@PathVariable int id){
        Optional <User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw  new UserNotFoundException("id:"+id);
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());


        EntityModel <User> entityModel= EntityModel.of(user.get());
        entityModel.add(linkBuilder.withRel("all-users"));
        return entityModel ;
    }
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);

    }


}

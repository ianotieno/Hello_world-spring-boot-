package com.school.webservices.restfulwebservices;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private  static final List<User> users = new ArrayList<>();
    static {
        users.add(new User(1,"Mercy", LocalDate.now().minusYears(30)));
        users.add(new User(2,"Hellen", LocalDate.now().minusYears(50)));
        users.add(new User(3,"Joan", LocalDate.now().minusYears(28)));
        users.add(new User(4,"moreen", LocalDate.now().minusYears(34)));
    }
    public List<User> findAll(){
        return new ArrayList<>(users)   ;
    }
}

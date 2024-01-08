package com.school.webservices.restfulwebservices;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private  static int userCount=0;
    private  static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(++userCount,"Mercy", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Hellen", LocalDate.now().minusYears(50)));
        users.add(new User(++userCount,"Joan", LocalDate.now().minusYears(28)));
        users.add(new User(++userCount,"moreen", LocalDate.now().minusYears(34)));
    }

    public List<User> findAll(){
        return new ArrayList<>(users)   ;
    }
    public  User save (User user){
        user.setId(++userCount);
        users.add(user);
        return user;

    }
    public User findOne(int id){
        Predicate<? super User> Predicate = user -> user.getId().equals(id);
       return users.stream().filter(Predicate).findFirst().get() ;
    }

}

package xyz.bskapp.springrest.controllers;

import org.springframework.web.bind.annotation.*;
import xyz.bskapp.springrest.models.User;

import java.util.LinkedList;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @GetMapping(value = "test")
    public List<String> test(){
        return List.of("Hey", "My", "Name", "Is", "BerSerKer");
    }

    @GetMapping(value = "users")
    public List<User> getUsers(){
        List<User> users = new LinkedList<>();
        users.add(new User(1,"johan", "ibarra", "johan@email.com", "12345678", "12345678")) ;
        users.add(new User(2,"juan", "correa", "juan@email.com", "454646", "4564646")) ;
        users.add(new User(3,"pablo", "zapato", "pablo@email.com", "456464", "4564465")) ;
        return users;
    }

    @PostMapping(value = "users")
    public User createUser(){
        User user = new User(1,"johan", "ibarra", "johan@email.com", "12345678", "12345678");
        return user;
    }

    @DeleteMapping(value = "users/{id}")
    public String deleteUser(@PathVariable int id){
        return "{\"message\": \"User with id: " + id + " has been deleted\"}";
    }
}

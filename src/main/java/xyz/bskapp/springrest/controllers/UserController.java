package xyz.bskapp.springrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bskapp.springrest.dao.UserDao;
import xyz.bskapp.springrest.models.User;

import java.util.LinkedList;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "test")
    public List<String> test(){
        return List.of("Hey", "My", "Name", "Is", "BerSerKer");
    }

    @GetMapping(value = "users")
    public List<User> getUsers(){
        List<User> users = userDao.getUsers();
        return users;
    }

    @GetMapping(value = "users/{id}")
    public User getUser(@PathVariable int id){
        return userDao.getUserById(id);
    }

    @PostMapping(value = "users")
    public String createUser(@RequestBody User user){
        String response = "";
        try{
            response = userDao.createUser(user);
        }catch (Exception e){
            response = "{\"message\": \"This email is already on use\"}";
        }
        return response;
    }

/**
    @PutMapping(value = "users/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user){
        String response = "";
        try{
            response = userDao.updateUser(id, user);
        }catch (Exception e){
            response = "{\"message\": \"User Unknown\"}";
        }
        return response;
    }*/

    @DeleteMapping(value = "users/{id}")
    public String deleteUser(@PathVariable int id){
        String response = "";
        try{
            response = userDao.deleteUser(id);
        }catch (Exception e){
            response = "{\"message\": \"User Unknown\"}";
        }
        return response;
    }
}

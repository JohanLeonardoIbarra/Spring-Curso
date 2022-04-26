package xyz.bskapp.springrest.controllers;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.bskapp.springrest.dao.UserDao;
import xyz.bskapp.springrest.models.User;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "users")
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @GetMapping(value = "users/{id}")
    public User getUser(@PathVariable int id){
        return userDao.getUserById(id);
    }

    @PostMapping(value = "users")
    public String createUser(@RequestBody User user){
        String response;
        try{
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            String hash = argon2.hash(10, 1024, 3, user.getPassword().toCharArray());
            user.setPassword(hash);
            response = userDao.createUser(user);
        }catch (Exception e){
            response = "{\"message\": \"This email is already on use\"}";
        }
        return response;
    }


    @PutMapping(value = "users/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user){
        String response = "";
        try{
            response = userDao.updateUser(id, user);
        }catch (Exception e){
            response = "{\"message\": \"User Unknown\"}";
        }
        return response;
    }

    @DeleteMapping(value = "users/{id}")
    public String deleteUser(@PathVariable int id){
        String response;
        try{
            response = userDao.deleteUser(id);
        }catch (Exception e){
            response = "{\"message\": \"User Unknown\"}";
        }
        return response;
    }
}

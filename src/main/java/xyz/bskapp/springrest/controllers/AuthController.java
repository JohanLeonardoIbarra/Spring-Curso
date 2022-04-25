package xyz.bskapp.springrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.bskapp.springrest.dao.UserDao;
import xyz.bskapp.springrest.models.User;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @PostMapping(value = "login")
    public String loginUser(@RequestBody User user){
        String response = "";
        try{
            User dbUser = userDao.getUserByEmail(user.getEmail());
            if(dbUser.getPassword().equals(user.getPassword())){
                response = "{\"login\": true ,\"message\": \"User Logged In\"}";
                return response;
            }
            response = "{\"login\": false ,\"message\": \"Email or Password Weird\"}";
        }catch (Exception e){
            response = "{\"login\": false ,\"message\": \"Email or Password Weird x\"}";
        }
        return response;
    }
}

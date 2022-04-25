package xyz.bskapp.springrest.controllers;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        try{
            User dbUser = userDao.getUserByEmail(user.getEmail());
            String hash = dbUser.getPassword();
            if(argon2.verify(hash, user.getPassword().toCharArray())){
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

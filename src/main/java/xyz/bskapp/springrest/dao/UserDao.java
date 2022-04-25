package xyz.bskapp.springrest.dao;

import xyz.bskapp.springrest.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    String createUser(User user);
    //String deleteUser(int id);
    String updateUser(User user);
    String deleteUser(int id);
    User getUserById(int id);

    User getUserByEmail(String email);

}

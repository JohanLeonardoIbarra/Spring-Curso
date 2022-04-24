package xyz.bskapp.springrest.dao;

import xyz.bskapp.springrest.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    //String deleteUser(int id);
}

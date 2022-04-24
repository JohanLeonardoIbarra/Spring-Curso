package xyz.bskapp.springrest.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.bskapp.springrest.models.User;


import java.util.List;

@Repository
@Transactional
public class userDaoImp implements UserDao {

    @Override
    public List<User> getUsers() {
        return null;
    }
}

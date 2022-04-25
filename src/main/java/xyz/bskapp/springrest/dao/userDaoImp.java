package xyz.bskapp.springrest.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.bskapp.springrest.models.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class userDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getUsers() {
        String query = "SELECT u FROM User u";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public String createUser(User user) {
        entityManager.persist(user);
        return "{ \"message\": \"User created successfully\" }";
    }

    @Override
    public String updateUser(User user) {
        entityManager.merge(user);
        return "{ \"message\": \"User "+ user.getId() +" "+ user.getName() +" updated successfully\" }";
    }

    @Override
    public String deleteUser(int id) {
        entityManager.remove(getUserById(id));
        return "{ \"message\": \"User deleted successfully\"}";
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByEmail(String email) {
        String query = "SELECT u FROM User u WHERE u.email = :email";
        return entityManager.createQuery(query, User.class).setParameter("email", email).getSingleResult();
    }
}

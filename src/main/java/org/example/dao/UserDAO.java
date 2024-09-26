package org.example.dao;

import org.example.models.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findOne(Long id);

    void save(User user);

    void delete(Long id);

    void update(Long id, User user);
}

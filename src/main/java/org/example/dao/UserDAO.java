package org.example.dao;

import org.example.models.User;

import java.util.List;

public interface UserDAO {

    public List<User> findAll();

    public User findOne(Long id);

    public void save(User user);

    public void delete(Long id);

    void update(Long id, User user);
}

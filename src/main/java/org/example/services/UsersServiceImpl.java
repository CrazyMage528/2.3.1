package org.example.services;

import org.example.dao.UserDAO;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UserDAO userDAO;

    @Autowired
    public UsersServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userDAO.findOne(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional
    public void update(Long id, User user) {
        userDAO.update(id, user);
    }
}

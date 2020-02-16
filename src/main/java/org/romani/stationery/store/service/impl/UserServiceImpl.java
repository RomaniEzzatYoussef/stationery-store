package org.romani.stationery.store.service.impl;

import org.romani.stationery.store.models.User;
import org.romani.stationery.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.romani.stationery.store.dao.UserDAO;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    // need to inject customer dao
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {

        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {

        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {

        userDAO.deleteUser(id);
    }
}






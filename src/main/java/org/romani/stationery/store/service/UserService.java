package org.romani.stationery.store.service;

import org.romani.stationery.store.models.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}

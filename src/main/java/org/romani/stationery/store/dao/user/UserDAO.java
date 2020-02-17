package org.romani.stationery.store.dao.user;

import org.romani.stationery.store.models.User;

import java.util.List;


public interface UserDAO {

    public List<User> getUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}

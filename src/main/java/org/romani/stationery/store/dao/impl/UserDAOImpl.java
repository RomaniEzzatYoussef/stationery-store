package org.romani.stationery.store.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.romani.stationery.store.dao.UserDAO;
import org.romani.stationery.store.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query  ... sort by last name
        Query<User> userQuery = currentSession.createQuery("from User order by lastName", User.class);

        // execute query and get result list
        List<User> users = userQuery.getResultList();

        // return the results
        return users;
    }

    @Override
    public void saveUser(User user) {

        // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save/upate the customer ... finally LOL
        currentSession.saveOrUpdate(user);

    }

    @Override
    public User getUser(int id) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve/read from database using the primary key
        User user = currentSession.get(User.class, id);

        return user;
    }

    @Override
    public void deleteUser(int id) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query query =
                currentSession.createQuery("delete from User where id=:userId");
        query.setParameter("userId", id);

        query.executeUpdate();
    }

}

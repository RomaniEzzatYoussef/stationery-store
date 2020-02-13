package org.romani.stationery.store.rest;

import org.romani.stationery.store.models.User;
import org.romani.stationery.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    // autowire the CustomerService
    @Autowired
    private UserService userService;

    // add mapping for GET /customers
    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.getUsers();

    }

    // add mapping for GET /customers/{customerId}

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {

        User user = userService.getUser(userId);

        return user;
    }


}

package org.romani.stationery.store.rest;

import org.romani.stationery.store.models.GradeLevel;
import org.romani.stationery.store.models.User;
import org.romani.stationery.store.service.GradeLevelService;
import org.romani.stationery.store.service.UserService;
import org.romani.stationery.store.utilities.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private GradeLevelService gradeLevelService;


    @GetMapping("/grade/levels")
    public List<GradeLevel> getGradeLevels() {
        return gradeLevelService.getGradeLevels();
    }

    @GetMapping("/grade/level/{id}")
    public GradeLevel getGradeLevel(@PathVariable int id) {

        GradeLevel gradeLevel = gradeLevelService.getGradeLevel(id);

        if (gradeLevel == null) {
            throw new NotFoundException("GradeLevel id not found - " + id);
        }

        return gradeLevel;
    }



    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.getUsers();

    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {

        User user = userService.getUser(userId);

        if (user == null) {
            throw new NotFoundException("User id not found - " + userId);
        }

        return user;
    }


}

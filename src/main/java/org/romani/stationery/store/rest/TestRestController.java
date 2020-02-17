package org.romani.stationery.store.rest;

import org.romani.stationery.store.models.*;
import org.romani.stationery.store.service.gradelevel.GradeLevelService;
import org.romani.stationery.store.service.grade.GradeService;
import org.romani.stationery.store.service.product.ProductService;
import org.romani.stationery.store.service.user.UserService;
import org.romani.stationery.store.utilities.exceptions.NotFoundException;
import org.romani.stationery.store.utilities.json.GradeJSON;
import org.romani.stationery.store.utilities.json.GradeLevelJSON;
import org.romani.stationery.store.utilities.json.ProductJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class TestRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private GradeLevelService gradeLevelService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private ProductService productService;

    // for test
    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.getUsers();

    }

    // for test
    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {

        User user = userService.getUser(userId);

        if (user == null) {
            throw new NotFoundException("User id not found - " + userId);
        }

        return user;
    }

    // for test
    @GetMapping("/grade-levels")
    public List<GradeLevel> getAllGradeLevels() {
        return gradeLevelService.getGradeLevels();

    }

    @GetMapping("/grade/levels")
    public List<GradeLevelJSON> getGradeLevels() {
        List<GradeLevel> gradeLevels = gradeLevelService.getGradeLevels();

        List<GradeLevelJSON> gradeLevelJSONS = new ArrayList<>();
        for (int i = 0; i < gradeLevels.size(); i++) {
            GradeLevelJSON gradeLevelJSON = new GradeLevelJSON(gradeLevels.get(i).getId() , gradeLevels.get(i).getLevel());
            gradeLevelJSONS.add(gradeLevelJSON);
        }

        return gradeLevelJSONS;
    }


    @GetMapping("/grade/level/{id}")
    public List<GradeJSON> getGradeLevel(@PathVariable int id) {
        GradeLevel gradeLevel = gradeLevelService.getGradeLevel(id);

        if (gradeLevel == null) {
            throw new NotFoundException("GradeLevel id not found - " + id);
        }

        List<GradeJSON> gradeJSONS = new ArrayList<>();

        for (int i = 0; i < gradeLevel.getGrades().size(); i++) {
            GradeJSON gradeJSON = new GradeJSON(gradeLevel.getGrades().get(i).getGradeId() , gradeLevel.getGrades().get(i).getGrade());
            gradeJSONS.add(gradeJSON);
        }

        return gradeJSONS;
    }

    // for test
    @GetMapping("/grade/{id}")
    public Grade getGradeByID(@PathVariable int id) {

        Grade grade = gradeService.getGrade(id);

        if (grade == null) {
            throw new NotFoundException("Grade id not found - " + id);
        }

        return grade;
    }

    // for test
    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    // for test
    @GetMapping("/grades/{id}/products")
    public Grade getGradesProductsByID(@PathVariable int id) {

        Grade grade = gradeService.getGrade(id);

        if (grade == null) {
            throw new NotFoundException("Grade id not found - " + id);
        }

        return grade;
    }

    @GetMapping("/grade/{id}/products")
    public List<ProductJSON> getGradeProductsByID(@PathVariable int id) {

        Grade grade = gradeService.getGrade(id);

        if (grade == null) {
            throw new NotFoundException("Grade id not found - " + id);
        }

        List<ProductJSON> productJSONS = new ArrayList<>();
        for (int i = 0; i < grade.getClassifiedProducts().size(); i++) {

            ProductJSON productJSON = new ProductJSON();
            productJSON.setClassifiedProductId(grade.getClassifiedProducts().get(i).getClassifiedProductId());
            for (int r = 0; r < grade.getClassifiedProducts().get(i).getProducts().size(); r++) {
                productJSON.setProductId(grade.getClassifiedProducts().get(i).getProducts().get(r).getProductId());
                productJSON.setProductName(grade.getClassifiedProducts().get(i).getProducts().get(r).getProductName());
                productJSON.setCategoryName(grade.getClassifiedProducts().get(i).getProducts().get(r).getCategory().getName());
                productJSON.setDescription(grade.getClassifiedProducts().get(i).getProducts().get(r).getDescription());
//                productJSON.setImageUrl(grade.getClassifiedProducts().get(i).getProducts().get(r).getImageUrl());
//                Set<Offers> offers = grade.getClassifiedProducts().get(i).getProducts().get(r).getOffers();
//                List<Offers> list = new ArrayList<>(offers);
//                productJSON.setDiscount(list.get(0).getDiscount());
                productJSON.setMinStock(grade.getClassifiedProducts().get(i).getProducts().get(r).getMinStock());
            }

            productJSONS.add(productJSON);
        }
        return productJSONS;
    }



}

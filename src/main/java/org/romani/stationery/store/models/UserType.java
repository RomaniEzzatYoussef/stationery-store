package org.romani.stationery.store.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_type")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_type")
    private String userType;

//    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_type_id")
//    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//
//    public void addUser(User user) {
//        if (users == null) {
//            users = new ArrayList<>();
//        }
//
//        users.add(user);
//    }
}

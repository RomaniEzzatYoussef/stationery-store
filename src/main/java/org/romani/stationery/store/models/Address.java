package org.romani.stationery.store.models;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @ManyToOne(fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE,
//            CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column(name = "building")
    private int building;

    @Column(name = "apartment")
    private int apartment;

    @Column(name = "street_details")
    private String streetDetails;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "special_marque")
    private String specialMarque;

//    @ManyToMany(fetch = FetchType.EAGER , cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.REFRESH , CascadeType.PERSIST})
//    @JoinTable(name = "order_details" , joinColumns = @JoinColumn(name = "address_id") , inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<User> users;

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public String getStreetDetails() {
        return streetDetails;
    }

    public void setStreetDetails(String streetDetails) {
        this.streetDetails = streetDetails;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSpecialMarque() {
        return specialMarque;
    }

    public void setSpecialMarque(String specialMarque) {
        this.specialMarque = specialMarque;
    }


}

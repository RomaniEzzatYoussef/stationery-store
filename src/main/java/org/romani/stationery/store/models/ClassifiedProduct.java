package org.romani.stationery.store.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "classified_product")
public class ClassifiedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int classifiedProductId;

    @Column(name = "quantity")
    @JsonIgnore
    private int quantity;

    @OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id")
    @Fetch(FetchMode.JOIN)
    private List<Product> products;

    public ClassifiedProduct() {
    }

    public int getClassifiedProductId() {
        return classifiedProductId;
    }

    public void setClassifiedProductId(int classifiedProductId) {
        this.classifiedProductId = classifiedProductId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

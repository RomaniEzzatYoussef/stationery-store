package org.romani.stationery.store.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int productId;

    @Column(name = "name")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
//    @Fetch(FetchMode.JOIN)
    private List<ProductImages> imageUrl;

    @OneToMany(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
//    @Fetch(FetchMode.JOIN)
    private List<Offers> offers;

    @Column(name = "min_stock")
    private int minStock;

    public Product() {
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<ProductImages> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<ProductImages> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Offers> getOffers() {
        return offers;
    }

    public void setOffers(List<Offers> offers) {
        this.offers = offers;
    }
}

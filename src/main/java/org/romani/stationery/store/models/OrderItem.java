package org.romani.stationery.store.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "classified_product_id")
    private ClassifiedProduct classifiedProduct;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "submit_date")
    private Date submitDate;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price_per_unit")
    private int pricePerUnit;

    public OrderItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ClassifiedProduct getClassifiedProduct() {
        return classifiedProduct;
    }

    public void setClassifiedProduct(ClassifiedProduct classifiedProduct) {
        this.classifiedProduct = classifiedProduct;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}

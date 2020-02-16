package org.romani.stationery.store.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    @OneToOne
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;

    @Column(name = "submit_date")
    private Date submitDate;

    @Column(name = "estimated_days")
    private int estimatedDays;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "last_status_update_date")
    private Date lastStatusUpdateDate;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public int getEstimatedDays() {
        return estimatedDays;
    }

    public void setEstimatedDays(int estimatedDays) {
        this.estimatedDays = estimatedDays;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getLastStatusUpdateDate() {
        return lastStatusUpdateDate;
    }

    public void setLastStatusUpdateDate(Date lastStatusUpdateDate) {
        this.lastStatusUpdateDate = lastStatusUpdateDate;
    }
}

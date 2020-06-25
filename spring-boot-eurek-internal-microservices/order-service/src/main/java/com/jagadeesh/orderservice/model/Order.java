package com.jagadeesh.orderservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Order {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String customerName;
    @Column
    private Date orderDate;
    @Column
    private String shippingAddress;
    @Column
    private Double total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}

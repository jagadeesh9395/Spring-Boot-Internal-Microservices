package com.jagadeesh.orderItemservice.model;

import javax.persistence.*;

@Entity
@Table
public class OrderItem {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String productName;
    @Column
    private int quantity;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

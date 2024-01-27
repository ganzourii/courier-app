package com.goods.courierapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(name = "shipments_created")
    private int shipmentsCreated;

    @Column(name = "shipments_received")
    private int shipmentsReceived;

    public Customer() {
    }

    public Customer(User user, int shipmentsCreated, int shipmentsReceived) {
        this.user = user;
        this.shipmentsCreated = shipmentsCreated;
        this.shipmentsReceived = shipmentsReceived;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getShipmentsCreated() {
        return shipmentsCreated;
    }

    public void setShipmentsCreated(int shipmentsCreated) {
        this.shipmentsCreated = shipmentsCreated;
    }

    public int getShipmentsReceived() {
        return shipmentsReceived;
    }

    public void setShipmentsReceived(int shipmentsReceived) {
        this.shipmentsReceived = shipmentsReceived;
    }
    // Add other customer-specific columns

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", user=" + user.toString() +
                ", shipmentsCreated=" + shipmentsCreated +
                ", shipmentsReceived=" + shipmentsReceived +
                '}';
    }
}

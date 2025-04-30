package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order implements Comparable<Order> {
    private List<Food> foods;
    private Customer customer;
    private String orderType;
    private int orderId;
    private Driver driver;
    private LocalDateTime date;

    private final int nextId = 1;

    public Order(List<Food> foods, Customer customer, String orderType, int orderId, Driver driver, LocalDateTime date) {
        this.foods = foods;
        this.customer = customer;
        this.orderType = orderType;
        this.orderId = orderId;
        this.driver = driver;
        this.date = LocalDateTime.now();
    }

    @Override
    public int compareTo(Order o) {
        return 0;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

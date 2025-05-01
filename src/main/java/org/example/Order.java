package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Order implements Comparable<Order> {
    private List<Food> foods;
    private Customer customer;
    private int orderId;
    private LocalDateTime date;
    private String orderType;

    private static int nextId = 1;

    public Order() {
        this.foods = new ArrayList<>();
        this.customer = new Customer("");
        this.orderId = nextId++;
        this.date = LocalDateTime.now();
        this.orderType = "";
    }

    public Order(List<Food> foods, Customer customer, int orderId, LocalDateTime date, String orderType) {
        this.foods = foods;
        this.customer = customer;
        this.orderId = orderId;
        this.date = date;
        this.orderType = orderType;
    }

    /**
     * adds food inside order food list
     * @param food the input object food
     */
    public abstract void addFood(Food food);

    /**
     * removes food from order food list
     * @param food the input object food
     */
    public abstract void removeFood(Food food);

    /**
     * exports orders into csv file and info
     */
    public abstract void fileWriteOrder();

    /**
     * calculates total of the order (no tax)
     * @param foods the input food list
     * @return the total price of the order
     */
    public abstract double calcPrice(List<Food> foods);

    @Override
    public int compareTo(Order o) {
        return this.orderId - o.orderId;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Order.nextId = nextId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}

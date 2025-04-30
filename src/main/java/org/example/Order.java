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

    private static int nextId = 1;

    public Order() {
        this.foods = new ArrayList<>();
        this.customer = new Customer("");
        this.orderType = "Inside";
        this.orderId = nextId++;
        this.date = LocalDateTime.now();
    }

    public Order(List<Food> foods, Customer customer, String orderType, int orderId, Driver driver, LocalDateTime date) {
        this.foods = foods;
        this.customer = customer;
        this.orderType = orderType;
        this.orderId = orderId;
        this.driver = driver;
        this.date = date;
    }

    /**
     * adds food inside order food list
     * @param food the input object food
     */
    public static void addFood(Food food) {
        //TODO
    }

    /**
     * removes food from order food list
     * @param food the input object food
     */
    public static void removeFood(Food food) {
        //TODO
    }

    /**
     * exports orders into csv file and info
     */
    public static void fileWriteOrder() {
        //TODO
    }

    /**
     * calculates total of the order (no tax)
     * @param foods the input food list
     * @return the total price of the order
     */
    public static double calcPrice(List<Food> foods) {
        double price = 0;
        //TODO
        return price;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
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
}

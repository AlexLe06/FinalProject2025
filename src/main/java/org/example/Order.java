package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Order implements Comparable<Order> {
    private List<Food> foods;
    private String customerName;
    private int orderId;
    private LocalDateTime date;
    private String orderType;
    private Orderable operator;

    private static int nextId = 1;

    public Order(List<Food> foods, String customerName, int orderId, LocalDateTime date, String orderType) { //for driver
        this.foods = foods;
        this.customerName = customerName;
        this.orderId = orderId;
        this.date = date;
        this.orderType = orderType;
    }

    public Order(Orderable operator) {
        this.foods = new ArrayList<>();
        this.customerName = "";
        this.orderId = nextId++;
        this.date = LocalDateTime.now();
        this.orderType = "";
        this.operator = operator;
    }

    public Order(List<Food> foods, String customerName, int orderId, LocalDateTime date, String orderType, Orderable operator) {
        this.foods = foods;
        this.customerName = customerName;
        this.orderId = orderId;
        this.date = date;
        this.orderType = orderType;
        this.operator = operator;
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
     * calculates total of the order (no tax)
     * @param foods the input food list
     * @return the total price of the order
     */
    public abstract double calcPrice(List<Food> foods);

    @Override
    public int compareTo(Order o) {
        return this.orderId - o.orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && Objects.equals(foods, order.foods) && Objects.equals(customerName, order.customerName) && Objects.equals(date, order.date) && Objects.equals(orderType, order.orderType) && Objects.equals(operator, order.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foods, customerName, orderId, date, orderType, operator);
    }

    @Override
    public String toString() {
        String str = "";

        for (Food food : this.getFoods()) {
            str += food.getName() + ", ";
        }

        return str;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

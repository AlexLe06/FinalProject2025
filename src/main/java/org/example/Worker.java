package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Worker extends User implements Comparable<Worker>, Orderable {
    private int workerId;
    private Order tempOrder;

    private static int nextId = 1;

    public Worker(String name) {
        super(name);
        this.workerId = nextId++;
    }

    public Worker(String name, int age, Gender gender) {
        super(name, gender, age);
        this.workerId = nextId++;
    }

    public Worker(String name, int age, Gender gender, int workerId) {
        super(name, gender, age);
        this.workerId = workerId;
    }

    /**
     * refunds the customer the amount of their order they paid
     * @param customer the input object customer
     */
    public void refund(Customer customer) {
        double customerNewBalance = customer.getAccountBalance()
                + customer.getTempOrder().calcPrice(customer.getTempOrder().getFoods());
        customer.setAccountBalance(customerNewBalance);

        Restaurant.export(true);
    }

    /**
     * creates order for inside restaurant
     * @param isInRestaurant the input boolean if it is in restaurant
     */
    @Override
    public void createOrder(boolean isInRestaurant) {
        if (isInRestaurant) {
            tempOrder = new InRestaurantOrder(this);
        }

        Restaurant.export(false);
    }

    /**
     * adds food in the order
     * @param food the input object food
     */
    @Override
    public void addFoodOrder(Food food) {
        Orderable.super.addFoodOrder(food);
    }

    /**
     * removes food from the order
     * @param food the input object food
     */
    @Override
    public void removeFoodOrder(Food food) {
        Orderable.super.removeFoodOrder(food);
    }

    /**
     * displays information of worker
     * @return string of info about worker
     */
    @Override
    public String displayInfo() {
        return String.format("Name: %s, Age: %s, Gender: %s, WorkerId: %s", getName(), getAge(), getGender(), getWorkerId());
    }

    @Override
    public int compareTo(Worker o) {
        return this.workerId - o.workerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return workerId == worker.workerId && Objects.equals(tempOrder, worker.tempOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workerId, tempOrder);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerId=" + workerId +
                ", tempOrder=" + tempOrder +
                '}';
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Worker.nextId = nextId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public Order getTempOrder() {
        return tempOrder;
    }

    public void setTempOrder(Order tempOrder) {
        this.tempOrder = tempOrder;
    }
}

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
     * refund customer in case of a mistake
     * @param customer the input customer
//     * @param amount the input amount to refund
     */
    public void refund(Customer customer) {
        double customerNewBalance = customer.getAccountBalance()
                + customer.getTempOrder().calcPrice(customer.getTempOrder().getFoods());
        customer.setAccountBalance(customerNewBalance);

        Restaurant.export(true);
    }

    @Override
    public void createOrder(boolean isInRestaurant) {
        if (isInRestaurant) {
           this.tempOrder = new InRestaurantOrder(this);
        }

        //todo add in restaurant
    }

    @Override
    public void addFood(Food food) {
        if (tempOrder == null) {
            throw new IllegalStateException("Order cannot be null, it needs to be created first before adding food.");
        }
        if (food == null) {
            throw new IllegalStateException("Food cannot be null.");
        }
        tempOrder.getFoods().add(food);
    }

    @Override
    public void removeFood(Food food) {
        if (tempOrder == null) {
            throw new IllegalStateException("Order cannot be null, it needs to be created first before removing food.");
        }
        if (food == null) {
            throw new IllegalStateException("Food cannot be null.");
        }
        tempOrder.getFoods().remove(food);
    }

    /**
     * displays information about worker
     * @return string with information about worker
     */
    @Override
    public String displayInfo() {
        return String.format("%s, %s, %s, %s", getName(), getAge(), getGender(), getWorkerId());
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
        return workerId == worker.workerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workerId);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerId=" + workerId +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", gender=" + gender +
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

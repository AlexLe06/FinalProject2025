package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Driver extends User {
    private boolean availability;
    private List<Order> orders;

    public Driver(String name) {
        super(name);
        this.availability = true;
        this.orders = new ArrayList<>();
    }

    public Driver(String name, Gender gender, int age) {
        super(name, gender, age);
        this.availability = true;
        this.orders = new ArrayList<>();
    }

    public Driver(String name, Gender gender, int age, boolean availability, List<Order> orders) {
        super(name, gender, age);
        this.availability = availability;
        this.orders = orders;
    }

    /**
     * add order to the completed orders of the driver
     * @param order the input order
     */
    public void addOrder(Order order) {
        getOrders().add(order);
    }

    /**
     * allows the driver to view the orders he has that are pending
     * @return a string of all orders
     */
    public String viewOrders() {
        StringBuilder str = new StringBuilder();
        //TODO
        str.append(Restaurant.orders);
        return str.toString();
    }

    /**
     * manage order that driver receives
     * @param order the input object order
     * @return boolean of order is accepted
     */
    public boolean completedOrder(DeliveryOrder order) {
        //TODO
        return true;
    }

    /**
     * displays information about driver
     * @return a string of information about driver
     */
    @Override
    public String displayInfo() {
        return String.format("%s, %s, %s, %s", getName(), getAge(), getGender());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return availability == driver.availability && Objects.equals(orders, driver.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), availability, orders);
    }

    @Override
    public String
    toString() {
        return "Driver{" +
                "availability=" + availability +
                ", acceptedOrders=" + orders +
                '}';
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public static enum OrderStatus {
        DELIVERING, COMPLETED
    }
}

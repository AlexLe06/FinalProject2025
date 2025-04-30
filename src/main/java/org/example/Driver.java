package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Driver extends User implements Chargeable {
    private boolean availability;

    public Driver(String name, boolean availability) {
        super(name);
        this.availability = availability;
    }

    public Driver(String name) {
        super(name);
        this.availability = true;
    }

    public Driver(String name, Gender gender, int age, boolean availability) {
        super(name, gender, age);
        this.availability = availability;
    }

    /**
     * allows the delivery driver to view all his orders
     * @return list of orders driver has
     */
    public static List<Order> viewOrder() {
        //TODO
        return new ArrayList<>();
    }

    /**
     * allows the driver to accept or refuse his orders
     */
    public void manageOrder() {
        //TODO
    }

    /**
     * charges the customer amount
     * @param customer the input customer
     * @param amount the input amount
     */
    @Override
    public void charge(Customer customer, double amount) {
        Chargeable.super.charge(customer, amount);
    }

    /**
     * displays info about driver
     */
    @Override
    public void displayInfo() {
        //TODO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return availability == driver.availability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), availability);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "availability=" + availability +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}

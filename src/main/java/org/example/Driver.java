package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Driver extends User implements Chargeable {
    private boolean availability;

    public Driver(String name, Gender gender) {
        super(name, gender);
        this.availability = true;
    }

    public Driver(String name, Gender gender, boolean availability) {
        super(name, gender);
        this.availability = availability;
    }

    public static List<Order> viewOrder() {
        //TODO
        return new ArrayList<>();
    }

    public void manageOrder() {
        //TODO
    }

    @Override
    public void charge(Customer customer, double amount) {
        Chargeable.super.charge(customer, amount);
    }

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

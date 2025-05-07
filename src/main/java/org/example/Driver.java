package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Driver extends User implements Chargeable {
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
     * add order to the accepted orders of the driver
     * @param order the input order
     */
    public void addOrders(Order order) {
        getOrders().add(order);
    }

    /**
     * allows the driver to view the orders he has
     * @return a string of all orders
     */
    public String viewOrders() {
        String str = "";
        //TODO
        return str;
    }

    /**
     * manage order that driver receives
     * @param order the input object order
     * @param accept the input boolean accept
     * @return boolean of order is accepted
     */
    public boolean manageOrder(DeliveryOrder order, boolean accept) {
        //TODO
        return true;
    }

    /**
     * charges the customer amount
     * @param customer the input customer
     * @param amount the input amount
     */
    @Override
    public void charge(Customer customer, double amount) {
        Customer.pay(customer, amount);
    }

    /**
     * displays information about driver
     * @return a string of information about driver
     */
    @Override
    public String displayInfo() {
        String str = "";
        //TODO
        return str;
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
}

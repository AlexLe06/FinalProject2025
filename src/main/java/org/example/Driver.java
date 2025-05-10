package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Driver extends User {
    private List<Order> orders;

    public Driver(String name) {
        super(name);
        this.orders = new ArrayList<>();
    }

    public Driver(String name, Gender gender, int age) {
        super(name, gender, age);
        this.orders = new ArrayList<>();
    }

    /**
     * add pending delivery order to orders
     * @param order the input order
     */
    public void addOrder(Order order) {
        if (order instanceof DeliveryOrder) {
            getOrders().add(order);
        } else {
            throw new IllegalArgumentException("Only DeliveryOrder instances can be added.");
        }
    }

    /**
     * allows the driver to view the orders he has that are pending
     * @return a string of all orders
     */
    public String viewOrders() {
        StringBuilder str = new StringBuilder();

        for (Order order : orders) {
            str.append("Order " + order.getOrderId() + ",");
            str.append(order.getFoods().stream()
                    .map(Food::getName)
                    .collect(Collectors.joining(" | ")) + ",");
            str.append(order.getCustomerName() + ",");
            str.append(order.calcPrice(order.getFoods())+ "\n");
        }

        return str.toString();
    }

    /**
     * sets order to complete when done with it
     * @param order the input delivery order
     */
    public void completeOrder(DeliveryOrder order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        order.setStatus(DeliveryOrder.OrderStatus.COMPLETED);

        Restaurant.completedOrders.add(order);
        Restaurant.exportCompletedOrders();
    }

    /**
     * displays information about driver
     * @return a string of information about driver
     */
    @Override
    public String displayInfo() {
        return String.format("Name: %s, Gender: %s, Age: %s", getName(), getGender(), getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return Objects.equals(orders, driver.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orders);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "orders=" + orders +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

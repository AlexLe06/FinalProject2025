package org.example;

import java.util.Objects;

public class Worker extends User implements Comparable<Worker>, Orderable {
    private int workerId;

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
     * charges the customer
     */
    @Override
    public void charge() {
        Customer.pay();
    }

    /**
     * refund customer in case of a mistake
     * @param customer the input customer
     * @param amount the input amount to refund
     */
    public void refund(Customer customer) {
        double customerNewBalance = customer.getAccountBalance()
                + customer.getTempOrder().calcPrice(customer.getTempOrder().getFoods());
        customer.setAccountBalance(customerNewBalance);

        //TODO: call the logRefund in Restaurant class,m, passing true
    }

    public void createOrder(boolean isInRestaurant) {

    }

    public void addFood() {
        // TODO: call the add food from the order class
    }

    public void removeFood() {
        // TODO: call the remove food from the order class
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
}

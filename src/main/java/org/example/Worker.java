package org.example;

import java.util.Objects;

public class Worker extends User implements Comparable<Worker>, Chargeable{
    private int workerId;

    private static int nextId = 1;

    public Worker(String name) {
        super(name);
        this.workerId = nextId++;
    }

    public Worker(String name, int workerId) {
        super(name);
        this.workerId = workerId;
    }

    public Worker(String name, Gender gender, int age, int workerId) {
        super(name, gender, age);
        this.workerId = workerId;
    }

    /**
     * charges the customer
     * @param customer the input customer
     * @param amount the input amount charged
     */
    @Override
    public void charge(Customer customer, double amount) {
        Chargeable.super.charge(customer, amount);
    }

    /**
     * exports data about the order they took into a csv file and keep track of sales
     */
    public static void fileWrite() {
        //TODO
    }

    /**
     * displays info about the worker
     */
    @Override
    public void displayInfo() {
        //TODO
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

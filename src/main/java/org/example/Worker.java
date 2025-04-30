package org.example;

import java.util.Objects;

public class Worker extends User implements Comparable<Worker>, Chargeable{
    private int workerId;

    private static int nextId = 1;

    public Worker(String name, Gender gender) {
        super(name, gender);
        this.workerId = nextId++;
    }

    public Worker(String name, Gender gender, int workerId) {
        super(name, gender);
        this.workerId = workerId;
    }

    @Override
    public void charge(Customer customer, double amount) {
        Chargeable.super.charge(customer, amount);
    }

    public static void fileWrite() {
        //TODO
    }

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

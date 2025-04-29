package org.example;

public class Worker extends User implements Comparable<Worker> {
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
    public int compareTo(Worker o) {
        return this.workerId - o.workerId;
    }

    @Override
    public void displayInfo() {

    }
}

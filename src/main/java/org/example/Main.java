package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Worker worker = new Worker("Dog");
        Customer customer = new Customer("Alex", 1000);

        worker.charge(customer, 200);
        System.out.println(customer.getAccountBalance());

    }
}
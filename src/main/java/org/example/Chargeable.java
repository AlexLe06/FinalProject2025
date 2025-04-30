package org.example;

public interface Chargeable {
    default void charge(Customer customer, double amount) {
        //TODO
    }
}

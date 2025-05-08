package org.example;

public interface Orderable {

    /**
     * charges the customer the amount input
     */
     void createOrder(boolean isInRestaurant);

    default void addFood() {
        // TODO: call the add food from the order class
    }

    default void removeFood() {
        // TODO: call the remove food from the order class
    }
}

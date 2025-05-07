package org.example;

public interface Chargeable {

    /**
     * charges the customer the amount input
     * @param customer the input customer
     * @param amount the input amount
     */
    default void charge(Customer customer, double amount) {
        Customer.pay(customer, amount);
    }
}

package org.example;

import java.util.Objects;

public class Customer extends User {
    private double accountBalance;
    // add orderNumber?

    public Customer(String name) {
        super(name);
        this.accountBalance = 0;
    }

    public Customer(String name, double accountBalance) {
        super(name);
        this.accountBalance = accountBalance;
    }

    public Customer(String name, Gender gender, int age, double accountBalance) {
        super(name, gender, age);
        this.accountBalance = accountBalance;
    }

    /**
     * makes customer pay amount charged
     * @param customer the input customer
     * @param amount the input amount that is charged
     */
    public static void pay(Customer customer, double amount) {
        double newBalance = customer.getAccountBalance() - amount;
        customer.setAccountBalance(newBalance);
    }

    /**
     * allows customer to view menu
     * @param menu the input menu
     * @return a string that displays menu with all available food
     */
    public static String viewMenu(Menu menu) {
        String str = "";
        //TODO
        return str;
    }

    /**
     * displays information about customer
     * @return a string with information about customer
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
        Customer customer = (Customer) o;
        return Double.compare(accountBalance, customer.accountBalance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accountBalance);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accountBalance=" + accountBalance +
                '}';
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}

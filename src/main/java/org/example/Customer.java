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
     * takes amount that customer was charged off his account balance
     */
    public void pay() {
        //TODO
    }

    /**
     * allows customer to view the menu
     */
    public void viewMenu() {
        //TODO
    }

    /**
     * display info about customer
     */
    @Override
    public void displayInfo() {
        //TODO
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

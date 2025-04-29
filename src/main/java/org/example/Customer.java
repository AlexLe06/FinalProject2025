package org.example;

import java.util.Objects;

public class Customer extends User {
    private double accountBalance;

    public Customer(String name, Gender gender) {
        super(name, gender);
        this.accountBalance = 0;
    }

    public Customer(String name, Gender gender, double accountBalance) {
        super(name, gender);
        this.accountBalance = accountBalance;
    }

    public void pay() {
        //TODO
    }

    public void viewMenu() {
        //TODO
    }

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

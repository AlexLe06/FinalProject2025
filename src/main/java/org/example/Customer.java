package org.example;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Customer extends User implements Orderable{
    private double accountBalance;
    // add orderNumber?

    private List<Order> orders;
    private Order tempOrder;

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
     */
    public void pay() {
        tempOrder.setDate(LocalDateTime.now());
        orders.add(tempOrder);
        Restaurant.orders.add(tempOrder);

        // TODO: call the logData in the Restaurant class
        Restaurant.export(false);

        double totalPrice = tempOrder.calcPrice(tempOrder.getFoods());
        if (accountBalance >= totalPrice) {
            accountBalance -= totalPrice;
        } else {
            throw new IllegalStateException("Insufficient funds for customer: " + name);
        }
    }

    @Override
    public void createOrder(boolean isInRestaurant) {
        tempOrder = isInRestaurant
                ? new InRestaurantOrder(this)
                : new DeliveryOrder(this);
    }

    @Override
    public void addFoodOrder(Food food) {
        if (tempOrder == null) {
            throw new IllegalStateException("Order cannot be null, it needs to be created first before adding food.");
        }
        if (food == null) {
            throw new IllegalStateException("Food cannot be null.");
        }
        tempOrder.getFoods().add(food);
    }

    @Override
    public void removeFoodOrder(Food food) {
        if (tempOrder == null) {
            throw new IllegalStateException("Order cannot be null, it needs to be created first before removing food.");
        }
        if (food == null) {
            throw new IllegalStateException("Food cannot be null.");
        }
        tempOrder.getFoods().remove(food);
    }

    /**
     * allows customer to view menu
     * @param menu the input menu
     * @return a string that displays menu with all available food
     */
    public static String viewMenu(Menu menu) {
        return Menu.displayMenuCustomer(menu);
    }

    /**
     * displays information about customer
     * @return a string with information about customer
     */
    @Override
    public String displayInfo() {
        return String.format("Name: %s, Age: %s, Gender: %s, Balance: %.2f$", getName(), getAge(), getGender(), getAccountBalance());
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Order getTempOrder() {
        return tempOrder;
    }

    public void setTempOrder(Order tempOrder) {
        this.tempOrder = tempOrder;
    }
}

package org.example;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class DeliveryOrder extends Order {
    private Driver driver;
    private OrderStatus status;

    public DeliveryOrder(List<Food> foods, String customer, int orderId, LocalDateTime date, String orderType) {
        super(foods, customer, orderId, date, orderType);
        this.driver = new Driver("");
        this.status = OrderStatus.PENDING;
    }

    public DeliveryOrder(List<Food> foods, String customer, int orderId, LocalDateTime date, String orderType, Driver driver, OrderStatus status) {
        super(foods, customer, orderId, date, orderType);
        this.driver = driver;
        this.status = status;
    }

    public DeliveryOrder(Orderable operator) {
        super(operator);
        setOrderType("DeliveryOrder");
    }

    /**
     * reassign orders to drivers
     * @param order the input order
     * @param driver the input driver
     */
    public static void reassignDriver(DeliveryOrder order, Driver driver) {
        order.setDriver(driver);
    }

    /**
     * adds food inside order food list
     * @param food the input object food
     */
    @Override
    public void addFood(Food food) {
        getFoods().add(food);
    }

    /**
     * removes food from order food list
     * @param food the input object food
     */
    @Override
    public void removeFood(Food food) {
        getFoods().remove(food);
    }

    /**
     * exports orders into csv file and info
     */
    public void fileWriteOrder() {
        //TODO
    }

    /**
     * calculates total of the order (no tax)
     * @param foods the input food list
     * @return the total price of the order
     */
    @Override
    public double calcPrice(List<Food> foods) {
        double price = 0;

        for (Food food : foods) {
            price += food.getPrice();
        }

        return price;
    }

    @Override
    public int compareTo(Order o) {
        return super.compareTo(o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryOrder that = (DeliveryOrder) o;
        return Objects.equals(driver, that.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(driver);
    }

    @Override
    public String toString() {
        return "DeliveryOrder{" +
                "driver=" + driver +
                '}';
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String getOrderType() {
        return "Delivery";
    }

    @Override
    public void setOrderType(String orderType) {
        super.setOrderType(orderType);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public static enum OrderStatus {
        PENDING, ACCEPTED, REFUSED
    }
}

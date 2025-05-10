package org.example;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class DeliveryOrder extends Order {
    private String driverName;
    private OrderStatus status;

    public DeliveryOrder(List<Food> foods, String customer, int orderId, LocalDateTime date, String orderType) {
        super(foods, customer, orderId, date, orderType);
        this.driverName = "";
        this.status = OrderStatus.PENDING;
    }

    public DeliveryOrder(List<Food> foods, String customer, int orderId, LocalDateTime date, String orderType, String driverName, OrderStatus status) {
        super(foods, customer, orderId, date, orderType);
        this.driverName = driverName;
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
    public static void reassignDriver(DeliveryOrder order, String driver) {
        order.setDriverName(driver);
    }

    /**
     * adds food inside order food list
     * @param food the input object food
     */
    @Override
    public void addFood(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Food cannot be null");
        }

        getFoods().add(food);
    }

    /**
     * removes food from order food list
     * @param food the input object food
     */
    @Override
    public void removeFood(Food food) {
        if (getFoods().contains(food)) {
            getFoods().remove(food);
        } else {
            System.out.println("The order doesn't have " + food.getName());
        }
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
        return Objects.equals(driverName, that.driverName) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverName, status);
    }

    @Override
    public String toString() {
        return "DeliveryOrder{" +
                "driverName='" + driverName + '\'' +
                ", status=" + status +
                '}';
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
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
        PENDING, COMPLETED
    }
}

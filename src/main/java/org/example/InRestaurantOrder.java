package org.example;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class InRestaurantOrder extends Order{
    private Worker worker;

    public InRestaurantOrder(List<Food> foods, Customer customer, int orderId, LocalDateTime date, String orderType) {
        super(foods, customer, orderId, date, orderType);
        this.worker = new Worker("");
    }

    public InRestaurantOrder(List<Food> foods, Customer customer, int orderId, LocalDateTime date, String orderType, Worker worker) {
        super(foods, customer, orderId, date, orderType);
        this.worker = worker;
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
        if (getFoods().contains(food)) {
            getFoods().remove(food);
        } else {
            System.out.println("The order doesn't have " + food.getName());;
        }
    }


    /**
     * exports orders into csv file and info
     */
    @Override
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InRestaurantOrder that = (InRestaurantOrder) o;
        return Objects.equals(worker, that.worker);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(worker);
    }

    @Override
    public String toString() {
        return "InRestaurantOrder{" +
                "worker=" + worker +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        return super.compareTo(o);
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public String getOrderType() {
        return "In-Restaurant";
    }

    @Override
    public void setOrderType(String orderType) {
        super.setOrderType(orderType);
    }
}

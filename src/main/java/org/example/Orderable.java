package org.example;

public interface Orderable {

    Order getTempOrder();

    void createOrder(boolean isInRestaurant);

    default void addFoodOrder(Food food) {
        if (getTempOrder() == null) {
            throw new IllegalStateException("Order cannot be null, it needs to be created first before adding food.");
        }
        if (food == null) {
            throw new IllegalStateException("Food cannot be null.");
        }
        getTempOrder().addFood(food);
    }

    default void removeFoodOrder(Food food) {
        if (getTempOrder() == null) {
            throw new IllegalStateException("Order cannot be null, it needs to be created first before adding food.");
        }
        if (food == null) {
            throw new IllegalStateException("Food cannot be null.");
        }
        getTempOrder().removeFood(food);
    }
}

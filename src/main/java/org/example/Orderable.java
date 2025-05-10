package org.example;

public interface Orderable {

    Order getTempOrder();

    /**
     * create a temporary order
     * @param isInRestaurant boolean if it is in restaurant order
     */
    void createOrder(boolean isInRestaurant);

    /**
     * adds food inside the order
     * @param food the input object food
     */
    default void addFoodOrder(Food food) {
        if (getTempOrder() == null) {
            throw new IllegalStateException("Order cannot be null, it needs to be created first before adding food.");
        }
        if (food == null) {
            throw new IllegalStateException("Food cannot be null.");
        }
        getTempOrder().addFood(food);
    }

    /**
     * removes food from the order
     * @param food the input object food
     */
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

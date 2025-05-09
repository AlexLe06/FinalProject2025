package org.example;

public interface Orderable {
    void createOrder(boolean isInRestaurant);

    void addFood(Food food);

    void removeFood(Food food);
}

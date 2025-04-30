package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menu {
    private List<Food> foodsList;

    public Menu() {
        this.foodsList = new ArrayList<>();
    }

    public Menu(List<Food> foodsList) {
        this.foodsList = foodsList;
    }

    public void addFood() {
        //TODO
    }

    public void removeFood() {
        //TODO
    }

    public void displayMenu() {
        //TODO
    }

    public static boolean searchFood(String keyword) {
        //TODO
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(foodsList, menu.foodsList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(foodsList);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "foodsList=" + foodsList +
                '}';
    }

    public List<Food> getFoodsList() {
        return foodsList;
    }

    public void setFoodsList(List<Food> foodsList) {
        this.foodsList = foodsList;
    }
}

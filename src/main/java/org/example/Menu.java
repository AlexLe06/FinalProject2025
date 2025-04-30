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

    /**
     * adds food inside the menu
     * @param food the input object food
     */
    public void addFood(Food food) {
        //TODO
    }

    /**
     * remove food from menu
     * @param food the input object food
     */
    public void removeFood(Food food) {
        //TODO
    }

    /**
     * displays the menu, shows all food that is inside the menu
     */
    public void displayMenu() {
        //TODO
    }

    /**
     * searches food if it is inside the menu
     * @param keyword the input keyword
     * @return boolean if food is in the menu
     */
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

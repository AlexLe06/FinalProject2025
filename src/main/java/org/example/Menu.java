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
    public static void addFood(Food food) {
        //TODO
    }

    /**
     * remove food from menu
     * @param food the input object food
     */
    public static void removeFood(Food food) {
        //TODO
    }

    /**
     * displays menu of food
     * @return a string of all food on menu
     */
    public static String displayMenu() {
        String str = "";
        //TODO
        return str;
    }

    /**
     * searches food that contains the keyword in its name
     * @param keyword the input keyword
     * @return list of food that contains keyword from menu
     */
    public static List<Food> searchFood(String keyword) {
        List<Food> foods = new ArrayList<>();
        //TODO
        return foods;
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

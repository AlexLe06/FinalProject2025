package org.example;

import java.util.ArrayList;
import java.util.Collections;
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
        if (food == null) {
            throw new IllegalArgumentException("Food cannot be null");
        }

        for (Food food1 : getFoodsList()) {
            if (food1.getName().equalsIgnoreCase(food.getName())) {
                System.out.println("Food item already exists in menu: " + food.getName());
                return;
            }
        }

        getFoodsList().add(food);
    }

    /**
     * remove food from menu
     * @param food the input object food
     */
    public void removeFood(Food food) {
        if (food == null) {
            throw new IllegalArgumentException("Food cannot be null");
        }

        if (!getFoodsList().contains(food)) {
            System.out.println("Cannot remove non-existent food: " + food.getName());
            return;
        }

        getFoodsList().remove(food);
    }

    /**
     * get string of the menu
     * @param menu the input menu
     * @return string of menu
     */
    public static String displayMenu(Menu menu) { //try to change so that it displays in category already
        StringBuilder str = new StringBuilder();

            for (Food food : menu.getFoodsList()) {
                    str.append(food.getName()).append(", ");
                    str.append(String.format("%.2f$\n", food.getPrice()));
            }

        return str.toString();
    }

    /**
     * get string of the menu
     * @param menu the input menu
     * @return string of menu
     */
    public static String displayMenuCustomer(Menu menu) { //junit
        StringBuilder str = new StringBuilder();

        for (Food food : menu.getFoodsList()) {
            if (food.isAvailable()) {
                str.append(food.getName()).append(", ");
                str.append(String.format("%.2f$\n", food.getPrice()));
            }
        }

        return str.toString();
    }

    /**
     * get string of the menu
     * @param menu the input menu
     * @return
     */
    public String displayMenuCategory(Menu menu, String keyword) {
        StringBuilder str = new StringBuilder();
        String titleCaseKeyword = keyword.substring(0,1).toUpperCase() + keyword.substring(1).toLowerCase();

        str.append(titleCaseKeyword + ":\n");
        for (Food food : menu.getFoodsList()) {
            if (food.getCategory().equalsIgnoreCase(keyword)) {
                str.append(food.getName() + ", ");
                str.append(food.getPrice() + "$\n");
            }
        }

        return str.toString();
    }

    /**
     * searches food that contains the keyword in its name
     * @param keyword the input keyword
     * @return list of food that contains keyword from menu
     */
    public List<Food> searchFood(String keyword) {
        if (keyword == null) {
            return getFoodsList();
        }

        return getFoodsList().stream()
                .filter(food -> food.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
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

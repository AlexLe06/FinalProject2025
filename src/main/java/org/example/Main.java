package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        User worker = new Worker("Bob", 23, User.Gender.MALE);
        User worker1 = new Worker("Paul", 19, User.Gender.MALE);
        Customer customer = new Customer("Alex", User.Gender.MALE, 20, 1000);

        Menu menu = new Menu();
        Food food1 = new Food(12.99, "Burger", "Main", true);
        Food food2 = new Food(5.99, "Fries", "Side", true);
        Food food3 = new Food(8.99, "Nuggets", "Main", true);
        Food food4 = new Food(10.99, "Poutine", "Main", true);
        Food food5 = new Food(3.99, "Donut", "Dessert", true);
        Food food6 = new Food(4.28, "Ice Cream", "Dessert", false);

        menu.addFood(food1);
        menu.addFood(food2);
        menu.addFood(food3);
        menu.addFood(food4);
        menu.addFood(food5);
        menu.addFood(food6);

        customer.createOrder(true);
        customer.addFoodOrder(food1);
        customer.addFoodOrder(food2);
        customer.pay();
    }
}
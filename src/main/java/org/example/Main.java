package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker("Bob", 23, User.Gender.MALE);
        Worker worker1 = new Worker("Paul", 19, User.Gender.MALE);
        Customer customer = new Customer("Alex", 1000);

        customer.createOrder();
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

//        worker.charge(customer, 200);
//        System.out.println(customer.getAccountBalance());
        System.out.println(Customer.viewMenu(menu));

        System.out.println(worker.displayInfo());
        System.out.println(worker1.displayInfo());
    }
}
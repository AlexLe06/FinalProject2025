import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    @Test
    public void payTest() {
        Customer customer = new Customer("", 1000);
        Food food = new Food(10, "", "", true);
        Food food1 = new Food(10, "", "", true);
        List<Food> foods = new ArrayList<>();
        foods.add(food);
        foods.add(food1);

        Order order = new InRestaurantOrder(foods, customer, 1, LocalDateTime.now(), "");

        double total = order.calcPrice(order.getFoods()); //20

        double expected = 980;
        double result = customer.getAccountBalance() - total;

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void payTest_NotEnoughMoney() { //to modify
        Customer customer = new Customer("", 1000);
        Food food = new Food(500, "", "", true);
        Food food1 = new Food(510, "", "", true);
        List<Food> foods = new ArrayList<>();
        foods.add(food);
        foods.add(food1);

        Order order = new InRestaurantOrder(foods, customer, 1, LocalDateTime.now(), "");

        double total = order.calcPrice(order.getFoods()); //20

        double expected = 10;
        double result = customer.getAccountBalance() - total;

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void viewMenuTest() {
        User customer = new Customer("Bob", User.Gender.MALE, 14, 542);
        Food food1 = new Food(10, "Burger", "Main", true);
        Food food2 = new Food(16, "Poutine", "Main", true);
        Food food3 = new Food(15, "Fries", "Side", false);
        Food food4 = new Food(20, "Coca Cola", "Drink", true);
        List<Food> foods = List.of(food1, food2, food3, food4);
        Menu menu = new Menu(foods);

        String expected = "Burger, 10$\n"
                + "Poutine, 16$\n"
                + "Coca Cola, 20$\n";

        String result = Customer.viewMenu(menu);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void displayInfoTest() {
        User customer = new Customer("Bob", User.Gender.MALE, 14, 542);
        String expected = "Name: Bob, Gender: Male, Age: 14, Balance: 542";
        String result = customer.displayInfo();

        Assertions.assertEquals(expected, result);
    }
}

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

        Order order = new InRestaurantOrder(foods, "", 1, LocalDateTime.now(), "");

        customer.setTempOrder(order);

        customer.pay();
        double expected = 980;
        double result = customer.getAccountBalance();

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

        Order order = new InRestaurantOrder(foods, "", 1, LocalDateTime.now(), "");

        customer.setTempOrder(order);

        Assertions.assertThrows(IllegalStateException.class, () -> customer.pay());
    }

    @Test
    public void viewMenuTest() {
        Food food1 = new Food(10, "Burger", "Main", true);
        Food food2 = new Food(16, "Poutine", "Main", true);
        Food food3 = new Food(15, "Fries", "Side", false);
        Food food4 = new Food(20, "Coca Cola", "Drink", true);
        List<Food> foods = List.of(food1, food2, food3, food4);
        Menu menu = new Menu(foods);

        String expected = "Burger, 10.00$\n"
                + "Poutine, 16.00$\n"
                + "Coca Cola, 20.00$\n";

        String result = Customer.viewMenu(menu);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void displayInfoTest() {
        User customer = new Customer("Bob", User.Gender.MALE, 14, 542);
        String expected = "Name: Bob, Age: 14, Gender: MALE, Balance: 542.00$";
        String result = customer.displayInfo();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void createOrderTest_InRestaurant() {
        Customer customer = new Customer("John");
        customer.createOrder(true);

        Assertions.assertTrue(customer.getTempOrder() instanceof InRestaurantOrder);
    }

    @Test
    public void createOrderTest_Delivery() {
        Customer customer = new Customer("John");
        customer.createOrder(false);

        Assertions.assertTrue(customer.getTempOrder() instanceof DeliveryOrder);
    }
}

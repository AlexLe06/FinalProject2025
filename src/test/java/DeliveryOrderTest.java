import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DeliveryOrderTest {

    @Test
    public void addFoodTest() {
        Customer customer = new Customer("", 1000);
        Food food = new Food(500, "la", "", true);
        Food food1 = new Food(510, "ba", "", true);
        Food food2 = new Food(510, "ca", "", true);
        List<Food> foods = new ArrayList<>();
        foods.add(food);
        foods.add(food1);

        Order order = new DeliveryOrder(foods, customer, 1, LocalDateTime.now(), "");

        Order expected = new DeliveryOrder(List.of(food, food1, food2), customer, 1, LocalDateTime.now(), "");
        order.addFood(food2);

        Assertions.assertEquals(expected.getFoods(), order.getFoods());
    }

    @Test
    public void removeFoodTest() {
        Customer customer = new Customer("", 1000);
        Food food = new Food(500, "la", "", true);
        Food food1 = new Food(510, "ba", "", true);
        Food food2 = new Food(510, "ca", "", true);
        List<Food> foods = new ArrayList<>();
        foods.add(food);
        foods.add(food1);
        foods.add(food2);

        Order order = new DeliveryOrder(foods, customer, 1, LocalDateTime.now(), "");

        Order expected = new DeliveryOrder(List.of(food1, food2), customer, 1, LocalDateTime.now(), "");
        order.removeFood(food);

        Assertions.assertEquals(expected.getFoods(), order.getFoods());
    }

    @Test
    public void calcPriceTest() {
        Customer customer = new Customer("", 1000);
        Food food = new Food(10, "", "", true);
        Food food1 = new Food(10, "", "", true);
        List<Food> foods = new ArrayList<>();
        foods.add(food);
        foods.add(food1);

        Order order = new DeliveryOrder(foods, customer, 1, LocalDateTime.now(), "");

        double expected = 20;
        double result = order.calcPrice(order.getFoods());

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void reassignDriverTest() {
        Driver driver = new Driver("Bob");

        Order expected = new DeliveryOrder(new ArrayList<>(), new Customer(""), 1, LocalDateTime.now(), "", driver, DeliveryOrder.OrderStatus.PENDING);
        Order order = new DeliveryOrder(new ArrayList<>(), new Customer(""), 1, LocalDateTime.now(), "", new Driver(""), DeliveryOrder.OrderStatus.PENDING);

        DeliveryOrder.reassignDriver((DeliveryOrder) order, driver);

        Assertions.assertEquals(((DeliveryOrder) expected).getDriver(), ((DeliveryOrder) expected).getDriver());
    }
}

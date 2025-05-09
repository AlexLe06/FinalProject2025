import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderableTest {

    @Test
    public void addFoodOrderTest() {
        Customer customer = new Customer("Bob");
        customer.createOrder(true);

        Food food = new Food(12.0, "Pizza", "Main", true);
        customer.addFoodOrder(food);

        List<Food> expected = List.of(food);
        List<Food> result = customer.getTempOrder().getFoods();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void removeFoodOrderTest() {
        Customer customer = new Customer("Bob");
        customer.createOrder(true);

        Food food = new Food(12.0, "Pizza", "Main", true);
        Food food1 = new Food(15.0, "Pizza", "Main", true);
        customer.addFoodOrder(food);
        customer.addFoodOrder(food1);

        customer.removeFoodOrder(food);

        List<Food> expected = List.of(food1);
        List<Food> result = customer.getTempOrder().getFoods();

        Assertions.assertEquals(expected, result);;
    }
}

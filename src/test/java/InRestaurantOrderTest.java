import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InRestaurantOrderTest {
    @Test
    public void addFoodTest() {
        Food food = new Food(500, "la", "", true);
        Food food1 = new Food(510, "ba", "", true);
        Food food2 = new Food(510, "ca", "", true);
        List<Food> foods = new ArrayList<>();
        foods.add(food);
        foods.add(food1);

        Order order = new InRestaurantOrder(foods, "", 1, LocalDateTime.now(), "");

        Order expected = new InRestaurantOrder(List.of(food, food1, food2), "", 1, LocalDateTime.now(), "");
        order.addFood(food2);

        Assertions.assertEquals(expected.getFoods(), order.getFoods());
    }

    @Test
    public void removeFoodTest() {
        Food food = new Food(500, "la", "", true);
        Food food1 = new Food(510, "ba", "", true);
        Food food2 = new Food(510, "ca", "", true);
        List<Food> foods = new ArrayList<>();
        foods.add(food);
        foods.add(food1);
        foods.add(food2);

        Order order = new InRestaurantOrder(foods, "", 1, LocalDateTime.now(), "");

        Order expected = new InRestaurantOrder(List.of(food1, food2), "", 1, LocalDateTime.now(), "");
        order.removeFood(food);

        Assertions.assertEquals(expected.getFoods(), order.getFoods());
    }

    @Test
    public void calcPriceTest() {
        Food food = new Food(10, "", "", true);
        Food food1 = new Food(10, "", "", true);
        List<Food> foods = new ArrayList<>();
        foods.add(food);
        foods.add(food1);

        Order order = new InRestaurantOrder(foods, "", 1, LocalDateTime.now(), "");

        double expected = 20;
        double result = order.calcPrice(order.getFoods());

        Assertions.assertEquals(expected, result);
    }
}

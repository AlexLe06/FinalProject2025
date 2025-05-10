import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WorkerTest {

    @Test
    public void displayInfoTest() {
        User worker = new Worker("Bob",  18, User.Gender.MALE,1);
        String expected = "Name: Bob, Age: 18, Gender: MALE, WorkerId: 1";
        String result = worker.displayInfo();

        Assertions.assertEquals(expected, result);
    }


    @Test
    public void refundTest() {
        Customer customer = new Customer("Bob", 1000);
        Worker worker = new Worker("Bob",  18, User.Gender.MALE,1);

        List<Food> foods = new ArrayList<>();
        Food food1 = new Food(13, "w", "wa", true);
        Food food2 = new Food(17, "afae", "addf", true);
        foods.add(food1);
        foods.add(food2);

        Order order = new InRestaurantOrder(foods, customer.getName(), 1, LocalDateTime.now(), "inRestaurant");
        customer.setTempOrder(order);

        worker.refund(customer);

        double expected = 1030;
        double result = customer.getAccountBalance();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void createOrderTest() {
        Worker worker = new Worker("John");
        worker.createOrder(true);

        Assertions.assertTrue(worker.getTempOrder() instanceof InRestaurantOrder);
    }
}

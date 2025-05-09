import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DriverTest {

    @Test
    public void displayInfoTest() {
        User driver = new Driver("Bob", User.Gender.MALE, 29);
        String expected = "Name: Bob, Gender: MALE, Age: 29";
        String result = driver.displayInfo();

        Assertions.assertEquals(expected, result);
    }

//    @Test
//    public void viewOrdersTest() { //TODO
//        Driver driver = new Driver("Bob");
//        Order order1 = new DeliveryOrder(new ArrayList<>(), "", 1, LocalDateTime.now(),
//                "", driver, DeliveryOrder.OrderStatus.ACCEPTED);
//        Order order2 = new DeliveryOrder(new ArrayList<>(), "", 2, LocalDateTime.now(),
//                "", driver, DeliveryOrder.OrderStatus.ACCEPTED);
//        Order order3 = new DeliveryOrder(new ArrayList<>(), "", 3, LocalDateTime.now(),
//                "", driver, DeliveryOrder.OrderStatus.PENDING);
//        driver.addOrder(order1);
//        driver.addOrder(order2);
//        driver.addOrder(order3);
//
//
//        String expected = "Order 1: ACCEPTED, Order 2: ACCEPTED, Order 3: PENDING";
//        String result = driver.viewOrders();
//
//        Assertions.assertEquals(expected, result);
//    }

    @Test
    public void addOrderTest() {
        Driver driver = new Driver("Bob");
        Order order1 = new DeliveryOrder(new ArrayList<>(), "", 1, LocalDateTime.now(),
                "", driver, DeliveryOrder.OrderStatus.ACCEPTED);
        Order order2 = new DeliveryOrder(new ArrayList<>(), "", 2, LocalDateTime.now(),
                "", driver, DeliveryOrder.OrderStatus.ACCEPTED);
        Order order3 = new DeliveryOrder(new ArrayList<>(), "", 3, LocalDateTime.now(),
                "", driver, DeliveryOrder.OrderStatus.REFUSED);
        driver.addOrder(order1);
        driver.addOrder(order2);

        List<Order> expected = List.of(order1, order2);
        List<Order> result = driver.getOrders();

        Assertions.assertEquals(expected, result);
    }
}

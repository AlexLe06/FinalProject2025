import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DriverTest {

    @Test
    public void displayInfoTest() {
        User driver = new Driver("Bob", User.Gender.MALE, 29);
        String expected = "Name: Bob, Gender: MALE, Age: 29";
        String result = driver.displayInfo();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void completeOrderTest() {
        Driver driver = new Driver("Bob");
        DeliveryOrder order = new DeliveryOrder(new ArrayList<>(), "", 1, LocalDateTime.now(),
                "DeliveryOrder", "", DeliveryOrder.OrderStatus.PENDING);

        driver.completeOrder(order);
        Assertions.assertEquals(DeliveryOrder.OrderStatus.COMPLETED, order.getStatus());
    }

    @Test
    public void viewOrdersTest() { //TODO
        User driver = new Driver("Bob");
        Order order1 = new DeliveryOrder(new ArrayList<>(), "", 1, LocalDateTime.now(),
                "", "Bob", DeliveryOrder.OrderStatus.COMPLETED);
        Order order2 = new DeliveryOrder(new ArrayList<>(), "", 2, LocalDateTime.now(),
                "", "Bob", DeliveryOrder.OrderStatus.COMPLETED);
        Order order3 = new DeliveryOrder(new ArrayList<>(), "", 3, LocalDateTime.now(),
                "", "Bob", DeliveryOrder.OrderStatus.PENDING);
        ((Driver) driver).addOrder(order1);
        ((Driver) driver).addOrder(order2);

        StringBuilder str = new StringBuilder();

        for (Order order : ((Driver) driver).getOrders()) {
            str.append("Order " + order.getOrderId() + ",");
            str.append(order.getFoods().stream()
                    .map(Food::getName)
                    .collect(Collectors.joining(" | ")) + ",");
            str.append(order.getCustomerName() + ",");
            str.append(order.calcPrice(order.getFoods())+ "\n");
        }

        String expected = str.toString();
        String result = ((Driver) driver).viewOrders();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addOrderTest() {
        Driver driver = new Driver("Bob");
        Order order1 = new DeliveryOrder(new ArrayList<>(), "", 1, LocalDateTime.now(),
                "", "Bob", DeliveryOrder.OrderStatus.PENDING);
        Order order2 = new DeliveryOrder(new ArrayList<>(), "", 2, LocalDateTime.now(),
                "", "Bob", DeliveryOrder.OrderStatus.PENDING);
        Order order3 = new DeliveryOrder(new ArrayList<>(), "", 3, LocalDateTime.now(),
                "", "Bob", DeliveryOrder.OrderStatus.COMPLETED);
        driver.addOrder(order1);
        driver.addOrder(order2);

        List<Order> expected = List.of(order1, order2);
        List<Order> result = driver.getOrders();

        Assertions.assertEquals(expected, result);
    }
}

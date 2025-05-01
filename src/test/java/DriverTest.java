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
        String expected = "Name: Bob, Gender: Male, Age: 29";
        String result = driver.displayInfo();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void chargeTest() {
        Driver driver = new Driver("Dylan");
        Customer customer = new Customer("Bob", 1000);
        double amount = 200;

        driver.charge(customer, amount);

        double expected = 800;
        double result = customer.getAccountBalance();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void manageOrderTestPending() {
        Order order1 = new DeliveryOrder(new ArrayList<>(), new Customer(""), 1, LocalDateTime.now(),
                "", new Driver("Bob"), DeliveryOrder.OrderStatus.PENDING);

        Assertions.assertEquals(DeliveryOrder.OrderStatus.PENDING, ((DeliveryOrder) order1).getStatus());
    }

    @Test
    public void manageOrderTest_Accept() {
        Order order1 = new DeliveryOrder(new ArrayList<>(), new Customer(""), 1, LocalDateTime.now(),
                "", new Driver("Bob"), DeliveryOrder.OrderStatus.PENDING);

        ((DeliveryOrder) order1).setStatus(DeliveryOrder.OrderStatus.ACCEPTED);
        Assertions.assertEquals(DeliveryOrder.OrderStatus.ACCEPTED, ((DeliveryOrder) order1).getStatus());
    }

    @Test
    public void manageOrderTest_Negative() {
        Order order1 = new DeliveryOrder(new ArrayList<>(), new Customer(""), 1, LocalDateTime.now(),
                "", new Driver("Bob"), DeliveryOrder.OrderStatus.PENDING);

        ((DeliveryOrder) order1).setStatus(DeliveryOrder.OrderStatus.REFUSED);
        Assertions.assertEquals(DeliveryOrder.OrderStatus.REFUSED, ((DeliveryOrder) order1).getStatus());
    }

    @Test
    public void viewOrdersTest() {
        Driver driver = new Driver("Bob");
        Order order1 = new DeliveryOrder(new ArrayList<>(), new Customer(""), 1, LocalDateTime.now(),
                "", driver, DeliveryOrder.OrderStatus.ACCEPTED);
        Order order2 = new DeliveryOrder(new ArrayList<>(), new Customer(""), 2, LocalDateTime.now(),
                "", driver, DeliveryOrder.OrderStatus.ACCEPTED);
        Order order3 = new DeliveryOrder(new ArrayList<>(), new Customer(""), 3, LocalDateTime.now(),
                "", driver, DeliveryOrder.OrderStatus.PENDING);
        driver.addOrders(order1);
        driver.addOrders(order2);
        driver.addOrders(order3);


        String expected = "Order 1: ACCEPTED, Order 2: ACCEPTED, Order 3: PENDING";
        String result = driver.viewOrders();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addOrdersTest() {
        Driver driver = new Driver("Bob");
        Order order1 = new DeliveryOrder(new ArrayList<>(), new Customer(""), 1, LocalDateTime.now(),
                "", driver, DeliveryOrder.OrderStatus.ACCEPTED);
        Order order2 = new DeliveryOrder(new ArrayList<>(), new Customer(""), 2, LocalDateTime.now(),
                "", driver, DeliveryOrder.OrderStatus.ACCEPTED);
        Order order3 = new DeliveryOrder(new ArrayList<>(), new Customer(""), 3, LocalDateTime.now(),
                "", driver, DeliveryOrder.OrderStatus.REFUSED);
        driver.addOrders(order1);
        driver.addOrders(order2);

        List<Order> expected = List.of(order1, order2);
        List<Order> result = driver.getAcceptedOrders();

        Assertions.assertEquals(expected, result);
    }
}

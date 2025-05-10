package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Restaurant {
    public static final String ordersFile = "src/main/resources/order.csv";
    public static final String completedOrdersFile = "src/main/resources/completedOrders.csv";


    public static List<Order> orders = loadOrders(ordersFile);
    public static List<Order> completedOrders = loadDeliveryOrders(completedOrdersFile);

    /**
     * scans the orders inside file
     * @param path the input path file
     * @return a list of orders
     */
    private static List<Order> loadOrders(String path) {
        List<Order> orders = new ArrayList<>();

        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                String[] foodNames = parts[0].split("\\|");
                List<Food> foods = new ArrayList<>();
                for (String foodName : foodNames) {
                    foods.add(new Food(foodName)); //wrong because food dont have prices
                }

                String customerName = parts[1];
                int orderId = Integer.parseInt(parts[2]);
                LocalDateTime date = LocalDateTime.parse(parts[3]);
                String orderType = parts[4];

                orders.add(new InRestaurantOrder(foods, customerName, orderId, date, orderType));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return orders;
    }

    /**
     * scans the delivery orders inside file
     * @param path the input path file
     * @return a list of delivery orders
     */
    private static List<Order> loadDeliveryOrders(String path) {
        List<Order> orders = new ArrayList<>();

        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                String[] foodNames = parts[0].split("\\|");
                List<Food> foods = new ArrayList<>();
                for (String foodName : foodNames) {
                    foods.add(new Food(foodName)); //wrong because food dont have prices
                }

                String customerName = parts[1];
                int orderId = Integer.parseInt(parts[2]);
                LocalDateTime date = LocalDateTime.parse(parts[3]);
                String orderType = parts[4];
                String driverName = parts[5];
                DeliveryOrder.OrderStatus status = DeliveryOrder.OrderStatus.valueOf(parts[6]);

                orders.add(new DeliveryOrder(foods, customerName, orderId, date, orderType, driverName, status));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return orders;
    }

    /**
     * exports orders inside the csv file
     * @param isRefund the input boolean if it is a refund
     */
    public static void export(boolean isRefund) {
        writeOrders(isRefund, orders);
    }

    /**
     * exports completed orders of deliveries inside the csv file
     */
    public static void exportCompletedOrders() {
        writeCompletedOrders(completedOrders);
    }

    /**
     * writes the orders inside the csv file
     * @param isRefund he input boolean if it is a refund
     * @param orders the input list of orders
     */
    private static void writeOrders(boolean isRefund, List<Order> orders) {
        String path = "src/main/resources/order.csv";
        File file = new File(path);

        try (FileWriter fw = new FileWriter(file)) {
            for(Order order : orders) {
                fw.write(order.getFoods().stream()
                        .map(Food::getName)
                        .collect(Collectors.joining("|")) + ",");
                fw.write(order.getCustomerName() + ",");
                fw.write(order.getOrderId() + ",");
                fw.write(order.getDate() + ",");
                fw.write(order.getOrderType());

                if (isRefund) {
                    fw.write(",REFUND");
                }
                fw.write("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * writes the completed delivery orders inside the csv file
     * @param orders the input list of delivery orders
     */
    private static void writeCompletedOrders(List<Order> orders) {
        String path = "src/main/resources/completedOrders.csv";
        File file = new File(path);

        try (FileWriter fw = new FileWriter(file)) {
            for(Order order : orders) {
                DeliveryOrder deliveryOrder = (DeliveryOrder) order;

                fw.write(deliveryOrder.getFoods().stream()
                        .map(Food::getName)
                        .collect(Collectors.joining("|")) + ",");
                fw.write(deliveryOrder.getCustomerName() + ",");
                fw.write(deliveryOrder.getOrderId() + ",");
                fw.write(deliveryOrder.getDate() + ",");
                fw.write(deliveryOrder.getOrderType() + ",");
                fw.write(deliveryOrder.getDriverName() + ",");
                fw.write(deliveryOrder.getStatus().toString() + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

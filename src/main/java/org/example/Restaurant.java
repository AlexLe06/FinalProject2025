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
    public static final String orderFile = "src/main/resources/order.csv";


    public static List<Order> orders = loadOrders(orderFile);

    //Reading
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

    public static void export(boolean isRefund) {
        writeOrders(isRefund, orders);
    }

    //Writing
    private static void writeOrders(boolean isRefund, List<Order> orders) {
        String path = "src/main/resources/logs.csv";
        File file = new File(path);

        try (FileWriter fw = new FileWriter(file)) {
            for(Order order : orders) {
                if (!isRefund) {
                    fw.write(order.getFoods().stream()
                            .map(Food::getName)
                            .collect(Collectors.joining("|")) + ",");
                    fw.write(order.getCustomerName() + ",");
                    fw.write(order.getOrderId() + ",");
                    fw.write(order.getDate() + ",");
                    fw.write(order.getOrderType() + "\n");
                } else {
                    fw.write(order.getFoods().stream()
                            .map(Food::getName)
                            .collect(Collectors.joining("|")) + ",");
                    fw.write(order.getCustomerName() + ",");
                    fw.write(order.getOrderId() + ",");
                    fw.write(order.getDate() + ",");
                    fw.write(order.getOrderType() + ",");
                    fw.write("REFUND\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

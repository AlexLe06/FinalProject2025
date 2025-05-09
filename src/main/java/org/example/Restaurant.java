package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Restaurant {
    public static final String orderFile = "src/main/resources/order.csv";

//    public static final String customersFile = "src/main/resources/logs.csv";

    public static List<Order> orders = loadOrders(orderFile);


//    public static List<Customer> customers = new ArrayList<>();

    //Reading
    private static List<Order> loadOrders(String path) {
        List<Order> orders = new ArrayList<>();

        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");


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
                            .collect(Collectors.joining(" | ")));
                    fw.write(order.getCustomerName() + ",");
                    fw.write(order.getOrderId() + ", ");
                    fw.write(order.getOrderId() + ", ");
                    fw.write(order.getDate() + ", ");
                    fw.write(order.getOrderType() + "\n");
                } else {
                    fw.write(order.getFoods() + ",");
                    fw.write(order.getCustomerName() + ",");
                    fw.write(order.getOrderId() + ", ");
                    fw.write(order.getOrderId() + ", ");
                    fw.write(order.getDate() + ", ");
                    fw.write(order.getOrderType() + ", ");
                    fw.write("REFUND\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

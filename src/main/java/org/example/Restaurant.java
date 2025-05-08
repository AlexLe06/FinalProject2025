package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static List<Order> orders = new ArrayList<>();
    private static List<Customer> customers = loadOrders();


    //Reading
    private static List<Order> loadOrders() {

    }



    //Writing
    public static void writeOrders(boolean isRefund) {
        String path = "src/main/resources/logs.csv";
        File file = new File(path);

        try (FileWriter fw = new FileWriter(file)) {

            //TODO

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

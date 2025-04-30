package org.example;

import java.util.Comparator;
import java.util.Objects;

public class Food {
    private double price;
    private String name;
    private String category;
    private boolean isAvailable;

    public Food() {
        this.price = 0;
        this.name = "";
        this.category = "";
        this.isAvailable = true;
    }

    public Food(double price, String name, String category, boolean isAvailable) {
        this.price = price;
        this.name = name;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Double.compare(price, food.price) == 0 && isAvailable == food.isAvailable && Objects.equals(name, food.name) && Objects.equals(category, food.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, category, isAvailable);
    }

    @Override
    public String toString() {
        return "Food{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public class foodComparator implements Comparator<Food> {
        private final String keyword;

        public foodComparator(String keyword) {
            this.keyword = keyword;
        }

        @Override
        public int compare(Food o1, Food o2) {
            //TODO
            return 0;
        }
    }
}

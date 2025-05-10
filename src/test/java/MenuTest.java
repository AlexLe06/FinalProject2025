import org.example.Food;
import org.example.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MenuTest {

    @Test
    public void addFoodTest() {
        List<Food> foods = new ArrayList<>();
        Food food1 = new Food(12, "a", "", true);
        Food food2 = new Food(23, "f", "", true);
        Food food3 = new Food(34, "w", "", true);

        Menu menu = new Menu(foods);

        menu.addFood(food1);
        menu.addFood(food2);
        menu.addFood(food3);

        List<Food> expected = List.of(food1, food2, food3);
        List<Food> result = menu.getFoodsList();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void removeFoodTest() {
        Food food1 = new Food(12, "", "", true);
        Food food2 = new Food(12, "", "", true);
        Food food3 = new Food(12, "", "", true);
        List<Food> foods = new ArrayList<>();
        foods.add(food1);
        foods.add(food2);
        foods.add(food3);

        Menu menu = new Menu(foods);
        menu.removeFood(food1);

        List<Food> expected = List.of(food2, food3);
        List<Food> result = menu.getFoodsList();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void displayMenuTest() {
        Food food1 = new Food(10, "Burger", "Main", true);
        Food food2 = new Food(16, "Poutine", "Main", true);
        Food food3 = new Food(15, "Fries", "Side", false);
        Food food4 = new Food(20, "Coca Cola", "Drink", true);
        List<Food> foods = List.of(food1, food2, food3, food4);
        Menu menu = new Menu(foods);

        String expected = "Burger, 10.00$\n" + "Poutine, 16.00$\n" + "Fries, 15.00$\n" + "Coca Cola, 20.00$\n";
        String result = Menu.displayMenu(menu);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void displayMenuCustomerTest() {
        Food food1 = new Food(10, "Burger", "Main", true);
        Food food2 = new Food(16, "Poutine", "Main", true);
        Food food3 = new Food(15, "Fries", "Side", false);
        Food food4 = new Food(20, "Coca Cola", "Drink", true);
        List<Food> foods = List.of(food1, food2, food3, food4);
        Menu menu = new Menu(foods);

        String expected = "Burger, 10.00$\n" + "Poutine, 16.00$\n" + "Coca Cola, 20.00$\n";
        String result = Menu.displayMenuCustomer(menu);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void displayMenuCategoryTest() {
        String keyword = "Main";
        Food food1 = new Food(10, "Burger", "Main", true);
        Food food2 = new Food(16, "Poutine", "Main", true);
        Food food3 = new Food(15, "Fries", "Side", false);
        Food food4 = new Food(20, "Coca Cola", "Drink", true);
        List<Food> foods = List.of(food1, food2, food3, food4);
        Menu menu = new Menu(foods);

        String expected = "Main:\nBurger, 10.00$\n" + "Poutine, 16.00$\n";
        String result = Menu.displayMenuCategory(menu, keyword);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void searchFoodTest() {
        Food food1 = new Food(15, "Burger", "Burger", true);
        Food food2 = new Food(22, "Cheeseburger", "Burger", true);
        Food food3 = new Food(10, "Hotdog", "Sandwich", true);
        List<Food> foods = new ArrayList<>();
        foods.add(food1);
        foods.add(food2);
        foods.add(food3);

        Menu menu = new Menu();
        menu.setFoodsList(foods);
        String keyword = "burger";

        List<Food> expected = List.of(food1, food2);
        List<Food> result = menu.searchFood(keyword);

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void searchSpecificFoodTest() {
        Food food1 = new Food(15, "Burger", "Burger", true);
        Food food2 = new Food(22, "Cheeseburger", "Burger", true);
        Food food3 = new Food(10, "Hotdog", "Sandwich", true);
        List<Food> foods = new ArrayList<>();
        foods.add(food1);
        foods.add(food2);
        foods.add(food3);

        Menu menu = new Menu();
        menu.setFoodsList(foods);
        String keyword = "burger";

        Food result = menu.searchSpecificFood(keyword);

        Assertions.assertEquals(food1, result);
    }
}

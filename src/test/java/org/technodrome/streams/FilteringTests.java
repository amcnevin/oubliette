package org.technodrome.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.technodrome.models.Dish;
import org.technodrome.utils.Utils;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FilteringTests {

    private List<Dish> menu;
    private Filtering subject;

    @BeforeEach
    public void setUp() {
        menu = Utils.constructMenu();
        subject = Filtering.getInstance();
    }

    @Test
    @DisplayName("Filter on Meat Type Dishes")
    public void testFilterMeat() {
        List<Dish> carnivoreMenu = subject.filterMeatDishes(menu);
        assertFalse(carnivoreMenu.isEmpty());
        carnivoreMenu.forEach(d-> assertEquals(d.getType(), Dish.Type.MEAT));
    }

    @Test
    @DisplayName("Filter on Vegetarian Dishes")
    public void testFilterVegetarian() {
        List<Dish> vegetarianMenu = subject.filterVegetarian(menu);
        assertFalse(vegetarianMenu.isEmpty());
        vegetarianMenu.forEach(d->assertTrue(d.isVegetarian()));
    }

    @Test
    @DisplayName("Filter on Calories")
    public void testFilterCalories() {
        int caloricLimit = 300;
        List<Dish> caloricMenu = subject.filterCaloriesOverXAmount(menu, caloricLimit);
        assertFalse(caloricMenu.isEmpty());
        caloricMenu.forEach(d->assertTrue(d.getCalories() > caloricLimit));
    }

    @Test
    @DisplayName("Limit Dishes")
    public void testLimitDishes() {
        int limit = 2;
        List<Dish> expectedLimitedMenu = Arrays.asList(menu.get(0), menu.get(1));
        List<Dish> limitedMenu = subject.truncateStreamByXLimit(menu, limit);
        assertEquals(expectedLimitedMenu, limitedMenu);
        assertEquals(limit, limitedMenu.size());
    }

    @Test
    @DisplayName("Skip Dishes")
    public void testSkipDishes() {
        int skipLimit = 2;
        Dish dishNotFound1 = menu.get(0);
        Dish dishNotFound2 = menu.get(1);

        List<Dish> skippedMenu = subject.skipDishesByXAmount(menu, skipLimit);
        assertFalse(skippedMenu.isEmpty());
        assertFalse(skippedMenu.contains(dishNotFound1));
        assertFalse(skippedMenu.contains(dishNotFound2));
        assertEquals(menu.size()-skipLimit, skippedMenu.size());
    }
}

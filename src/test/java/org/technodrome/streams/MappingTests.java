package org.technodrome.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.technodrome.models.Dish;
import org.technodrome.utils.Utils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MappingTests {

    private List<Dish> menu;
    private Mapping subject;

    @BeforeEach
    public void setUp() {
        menu = Utils.constructMenu();
        subject = Mapping.getInstance();
    }

    @Test
    @DisplayName("Get Dish Names")
    public void testGetDishNames() {
        List<String> dishNames = subject.getDishNames(menu);
        assertFalse(dishNames.isEmpty());
        menu.forEach(d->assertTrue(dishNames.contains(d.getName())));
    }

    @Test
    @DisplayName("Get Dish Calories")
    public void testGetDishCalories() {
        List<Integer> calories = subject.getDishCalories(menu);
        assertFalse(calories.isEmpty());
        menu.forEach(d->assertTrue(calories.contains(d.getCalories())));
    }

    @Test
    @DisplayName("Get Flattened Menu")
    public void testflattenMenus() {
        List<List<Dish>> listOfMenus = Arrays.asList(menu, Utils.constructMenu(), Utils.constructMenu());
        List<Dish> flattened = subject.flattenMenus(listOfMenus);
        assertFalse(flattened.isEmpty());
        assertEquals(3 * menu.size(), flattened.size());
    }

    @Test
    @DisplayName("Get Sum of Calories")
    public void testSumCalories() {
        int sum = subject.getSumOfCalories(menu);
        assertTrue(sum > 0);
        int expectedSum = 0;
        for (Dish dish : menu) {
            expectedSum += dish.getCalories();
        }
        assertEquals(expectedSum, sum);
    }

    @Test
    @DisplayName("Get Avg of Calories")
    public void testAvgCalories() {
        double avg = subject.getAverageCalories(menu);
        assertTrue(avg > menu.size());
        double expectedSum = 0;
        for (Dish dish : menu) {
            expectedSum += dish.getCalories();
        }
        // watch the precision
        double expectedAvg = (double) (expectedSum / menu.size());
        assertEquals(expectedAvg, avg);
    }

    @Test
    @DisplayName("Get Max Calories")
    public void testMaxCalories() {
        Integer max = subject.getMaxCalories(menu);
        assertTrue(max > 0);
    }

    @Test
    @DisplayName("Get Min Calories")
    public void  testMinCalories() {
        Integer min = subject.getMinCalories(menu);
        assertTrue(min > 0);
    }
}

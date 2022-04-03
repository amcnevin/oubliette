package org.technodrome.streams;

import org.technodrome.models.Dish;

import java.util.List;
import java.util.stream.Collectors;

final class Filtering {

    private static Filtering instance;

    private Filtering() {

    }

    public static Filtering getInstance() {
        if (instance == null) {
            instance = new Filtering();
        }
        return instance;
    }

    /**
     * filter out just the Meat Type Dishes
     * @param menu a provided Menu of Dishes
     * @return a List of Dishes where Type is MEAT
     */
    public List<Dish> filterMeatDishes(List<Dish> menu) {
        return menu.stream()
                .filter(d -> d.getType().equals(Dish.Type.MEAT))
                .collect(Collectors.toList());
    }

    /**
     * filter out just the Vegetarian Dishes
     * @param menu a provided Menu of Dishes
     * @return a List of Dishes where isVegetarian is True
     */
    public List<Dish> filterVegetarian(List<Dish> menu) {
        return menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
    }

    /**
     * filter out Dishes with calories over X
     * @param menu a provided Menu of Dishes
     * @param x the caloric limit
     * @return a List of Dishes with calories over X amount
     */
    public List<Dish> filterCaloriesOverXAmount(List<Dish> menu, int x) {
        return menu.stream()
                .filter(d -> d.getCalories() > x)
                .collect(Collectors.toList());
    }

    /**
     * truncate the stream by x limit
     * @param menu a provided Menu of Dishes
     * @param limit the number to cap the stream
     * @return a List of Dishes within the limit
     */
    public List<Dish> truncateStreamByXLimit(List<Dish> menu, int limit) {
        return menu.stream()
            .limit(limit)
            .collect(Collectors.toList());
    }

    /**
     * skips X amount of dishes
     * @param menu a provided Menu of Dishes
     * @param skip the number of Dishes to Skip
     * @return a List of Dishes with x skipped
     */
    public List<Dish> skipDishesByXAmount(List<Dish> menu, int skip) {
        return menu.stream()
                .skip(skip)
                .collect(Collectors.toList());
    }
}
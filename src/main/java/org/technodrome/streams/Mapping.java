package org.technodrome.streams;

import org.technodrome.models.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Mapping {

    private static Mapping instance;

    private Mapping() {

    }

    public static Mapping getInstance() {
        if (instance == null) {
            instance = new Mapping();
        }
        return instance;
    }

    /**
     * get Name of each Dish
     * @param menu a provided Menu of Dishes
     * @return a List of Dish names
     */
    public List<String> getDishNames(List<Dish> menu) {
        return menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    /**
     * get Calories of each Dish
     * @param menu a provided Menu of Dishes
     * @return a List of Calories
     */
    public List<Integer> getDishCalories(List<Dish> menu) {
        return menu.stream()
                .map(Dish::getCalories)
                .collect(Collectors.toList());
    }

    /**
     * flatten a list Menus into a single list of Dishes
     * @param listOfMenus a list of menus
     * @return a List of combined Dishes
     */
    public List<Dish> flattenMenus(List<List<Dish>> listOfMenus) {
        return listOfMenus.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    /**
     * get Sum of Calories
     * @param menu a provided menu of Dishes
     * @return the sum of all calories
     */
    public Integer getSumOfCalories(List<Dish> menu) {
        return menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }

    /**
     * get Average of Calories per Dish
     * @param menu a provided menu of Dishes
     * @return the average calories per Dish
     */
    public double getAverageCalories(List<Dish> menu) {
        //converts a Stream<Dish> into a DoubleStream and handles the OptionalDouble
        return menu.stream()
                .mapToDouble(Dish::getCalories)
                .average().orElse(0.0);
    }

    /**
     * get a Map of Dish Type and Dishes
     * @param menu a provided menu of Dishes
     * @return a Map of Type and List of Dishes
     */
    public Map<Dish.Type, List<Dish>> getDishesByType(List<Dish> menu) {
        return menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
    }

    /**
     * get the Maximum amount of Calories
     * @param menu a provided menu of Dishes
     * @return Integer of the most Calories
     */
    public Integer getMaxCalories(List<Dish> menu) {
        return menu.stream()
                .max(Comparator.comparing(Dish::getCalories))
                .map(Dish::getCalories).orElse(0);
    }

    /**
     * get the Minimum amount of Calories
     * @param menu a provided menu of Dishes
     * @return Integer of the least Calories
     */
    public Integer getMinCalories(List<Dish> menu) {
        return menu.stream()
                .min(Comparator.comparing(Dish::getCalories))
                .map(Dish::getCalories).orElse(0);
    }

}

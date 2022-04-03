package org.technodrome.streams;

import org.technodrome.models.Dish;
import org.technodrome.utils.Utils;

import java.util.List;
import java.util.Optional;

class Matching {

    private static Matching instance;

    private Matching() {

    }

    public static Matching getInstance() {
        if (instance == null) {
            instance = new Matching();
        }
        return instance;
    }

    /**
     * determine if any dish is vegetarian
     * @param menu a provided menu of Dishes
     * @return boolean if Any Dish is vegetarian
     */
    public boolean isAnyVegetarian(List<Dish> menu) {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    /**
     * determine if all dishes are vegetarian
     * @param menu a provided menu of Dishes
     * @return boolean if all Dishes are vegetarian
     */
    public boolean isAllVegetarian(List<Dish> menu) {
        return menu.stream().allMatch(Dish::isVegetarian);
    }

    /**
     * determine if all dishes have calories
     * @param menu a provided menu of Dishes
     * @return boolean if each Dish has more than 1 calories
     */
    public boolean isAllCaloric(List<Dish> menu) {
        return menu.stream().allMatch(d->d.getCalories() > 0);
    }

    /**
     * find any Dish of Type fish
     * @param menu a provided menu of Dishes
     * @return Optional Dish of Type Fish
     */
    public Optional<Dish> findAnyFish(List<Dish> menu) {
        return menu.stream().filter(d->d.getType().equals(Dish.Type.FISH)).findAny();
    }

    /**
     * find the first Dish of Type Other
     * @param menu a provided menu of Dishes
     * @return Optional Dish of Type Other
     */
    public Optional<Dish> findFirstOther(List<Dish> menu) {
        return menu.stream().filter(d->d.getType().equals(Dish.Type.OTHER)).findFirst();
    }

}
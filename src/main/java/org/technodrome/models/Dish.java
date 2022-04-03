package org.technodrome.models;


import lombok.Getter;

public class Dish {

    @Getter private final String name;
    @Getter private final boolean vegetarian;
    @Getter private final int calories;
    @Getter private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }


    @Override
    public String toString() {
        return name;
    }


    public enum Type { MEAT, FISH, OTHER}
}

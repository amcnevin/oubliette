package org.technodrome.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.technodrome.models.Dish;
import org.technodrome.utils.Utils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MatchingTests {

    private List<Dish> menu;
    Matching subject;

    @BeforeEach
    public void setUp() {
        menu = Utils.constructMenu();
        subject = Matching.getInstance();
    }

    @Test
    @DisplayName("Are there any Vegetarian dishes")
    public void testIsAnyVegetarian() {
        boolean anyVegetation = subject.isAnyVegetarian(menu);
        assertTrue(anyVegetation);
    }

    @Test
    @DisplayName("Are all dishes Vegetarian")
    public void testAreAllVegetarian() {
        boolean allVegetarian = subject.isAllVegetarian(menu);
        assertFalse(allVegetarian);
    }

    @Test
    @DisplayName("Are all Dishes Caloric")
    public void testAreAllCaloric() {
        boolean allCaloric = subject.isAllCaloric(menu);
        assertTrue(allCaloric);
    }

    @Test
    @DisplayName("Find any Dishes of Type Fish")
    public void testFindAnyFish() {
        Optional<Dish> maybeFish = subject.findAnyFish(menu);
        assertTrue(maybeFish.isPresent());
        assertEquals(Dish.Type.FISH, maybeFish.get().getType());
    }

    @Test
    @DisplayName("Find First Other Type Dish")
    public void testFindFirstOtherType() {
        Optional<Dish> maybeOther = subject.findFirstOther(menu);
        assertTrue(maybeOther.isPresent());
        assertEquals(Dish.Type.OTHER, maybeOther.get().getType());
        Dish expectedFirst = null;
        for (Dish dish : menu) {
            if (dish.getType().equals(Dish.Type.OTHER)) {
                expectedFirst = dish;
                break;
            }
        }
        assertEquals(expectedFirst, maybeOther.get());

    }

}

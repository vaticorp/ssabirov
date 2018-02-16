package ru.job4j.task;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test-class for class CoffeeMachineTest.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 16.02.2018
 */
public class CoffeeMachineTest {
    @Test
    public void whenCoffeeCost35AndMoney50RubblesThen() {
        CoffeeMachine automaton = new CoffeeMachine();
        int[] changes = automaton.changes(50, 35);
        assertThat(new int[]{10, 5}, is(changes));
    }
    @Test
    public void whenCoffeeCost37AndMoney200RubblesThen() {
        CoffeeMachine automaton = new CoffeeMachine();
        int[] changes = automaton.changes(200, 37);
        assertThat(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 2, 1}, is(changes));
    }
}

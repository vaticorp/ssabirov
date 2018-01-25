package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test-class for Factorial.
 * @author Svyatoslav Sabirov
 * @since 25.01.2018
 * @version $id$.
 */
public class FactorialTest {

    @Test
    public void whenResultIsSmall() {

        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void whenResultIsBig() {

        Factorial factorial = new Factorial();
        int result = factorial.calc(8);
        assertThat(result, is(40320));
    }
}

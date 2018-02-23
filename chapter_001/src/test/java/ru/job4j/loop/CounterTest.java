package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test-class for Counter.
 * @author Svyatoslav Sabirov
 * @since 25.01.2018
 * @version $id$
 */

public class CounterTest {

    @Test
    public void whenSizeLessThenTen() {

        Counter counter = new Counter();
        int result = counter.add(1, 5);
        assertThat(result, is(6));
    }

    @Test
    public void whenSizeMoreThenTen() {

        Counter counter = new Counter();
        int result = counter.add(-2, 12);
        assertThat(result, is(28));
    }

}

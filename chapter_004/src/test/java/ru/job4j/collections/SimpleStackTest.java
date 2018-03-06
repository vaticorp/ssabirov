package ru.job4j.collections;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for SimpleStack.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 06.03.2018.
 */
public class SimpleStackTest {

    @Test
    public void whenAddTwoValueToQueueAndPoll() {
        SimpleStack<String> stackTest = new SimpleStack<String>();
        stackTest.push("Petr");
        stackTest.push("Max");
        stackTest.push("Oleg");
        assertThat(stackTest.poll(), is("Oleg"));
    }
}
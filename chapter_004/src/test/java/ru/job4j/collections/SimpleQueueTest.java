package ru.job4j.collections;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for SimpleQueue.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 06.03.2018.
 */
public class SimpleQueueTest {

    @Test
    public void whenAddTwoValueToQueueAndPoll() {
        SimpleQueue<String> queueTest = new SimpleQueue<String>();
        queueTest.push("Petr");
        queueTest.push("Max");
        queueTest.push("Oleg");
        assertThat(queueTest.poll(), is("Petr"));
    }
}
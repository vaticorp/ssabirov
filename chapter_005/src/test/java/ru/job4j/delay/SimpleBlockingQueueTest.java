package ru.job4j.delay;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for SimpleBlockingQueue.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 18.03.2018.
 */
public class SimpleBlockingQueueTest {
    @Test
    public void whenWeCreateToThreads() throws InterruptedException {

        SimpleBlockingQueue<String> testQueue = new SimpleBlockingQueue<String>();
        Thread producer = new Thread() {
            @Override
            public void run() {
                try {
                    testQueue.offer("First");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread user = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(testQueue.peek());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        producer.start();
        producer.join();
        user.start();
        user.join();
    }

}
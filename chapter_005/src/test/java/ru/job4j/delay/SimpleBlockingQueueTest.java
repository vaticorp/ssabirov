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

/*    @Test
    public void whenWeCreateToThreads() throws InterruptedException {

        SimpleBlockingQueue<Integer> testQueue = new SimpleBlockingQueue<Integer>();
        Thread producer = new Thread() {
            @Override
            public void run() {
                try {
                    for (int index = 0; index < 50; index++) {
                        testQueue.offer(index);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread user = new Thread() {
            @Override
            public void run() {
                try {
                    for (int index = 0; index < 50; index++) {
                        System.out.println(testQueue.peek());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        producer.start();
        user.start();
        producer.join();
        user.join();
        Thread.sleep(30000);
    }*/

}
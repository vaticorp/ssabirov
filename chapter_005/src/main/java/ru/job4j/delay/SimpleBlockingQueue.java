package ru.job4j.delay;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.*;

/**
 * This class represents Producer Consumer template.
 * @author Svyatoslav Sabirov.
 * @since 18.03.2018
 * @version 7.
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<T>();
    private boolean condition;

    public void offer(T value) throws InterruptedException {
        synchronized (this.queue) {
            this.queue.offer(value);
            this.condition = true;
            System.out.println("Нить " + Thread.currentThread().getName() + " добавила значение => будим остальные нити!");
            this.queue.notify();
        }
    }

    public T peek() throws InterruptedException {
        synchronized (this.queue) {
            while (!this.condition) {
                queue.wait();
                System.out.println("Нить " + Thread.currentThread().getName() + " спит и ожидает данные");
            }
            this.condition = this.queue.size() > 1;
        }
        return queue.peek();
    }
}

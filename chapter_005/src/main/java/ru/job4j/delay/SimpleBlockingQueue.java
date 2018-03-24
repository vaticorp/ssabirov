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
    private final Queue<T> queue = new LinkedList<T>();
    @GuardedBy("this")
    private final int size = 5; // максимально допустимое число

    public void offer(T value) throws InterruptedException {
        synchronized (this.queue) {
            while (queue.size() >= 5) {
                System.out.println("Очередь заполнена! Нить " + Thread.currentThread().getName() + " спит и ожидает данные");
                queue.wait();
            }
            this.queue.offer(value);
            System.out.println("Нить " + Thread.currentThread().getName() + " добавила значение => будим остальные нити!");
            this.queue.notify();
        }
    }

    public T peek() throws InterruptedException {
        synchronized (this.queue) {
            while (queue.isEmpty()) {
                System.out.println("Нить " + Thread.currentThread().getName() + " спит и ожидает данные");
                queue.wait();
            }
            T value = queue.peek();
            if (value != null) {
                queue.remove(value);
            }
            this.queue.notify();
            return value;
        }
    }
}

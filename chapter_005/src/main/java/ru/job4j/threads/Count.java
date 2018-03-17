package ru.job4j.threads;

import net.jcip.annotations.ThreadSafe;
import net.jcip.annotations.GuardedBy;

/**
 * This class represents Count.
 * @author Svyatoslav Sabirov.
 * @since 17.03.2018
 * @version 7.
 */
@ThreadSafe
public class Count {

    @GuardedBy("this")
    private int value;

    public synchronized void increment() {
        this.value++;
    }
    public synchronized int get() {
        return this.value;
    }
}

package ru.job4j.own;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class represents Lock.
 * @author Svyatoslav Sabirov.
 * @since 19.03.2018
 * @version 7.
 */
public class OwnLock {

    private Thread currentThread;

    public synchronized void lock() {
        if (currentThread == null) {
            currentThread = Thread.currentThread();
        }
    }

    public synchronized void unlock() {
        if (currentThread != null && currentThread == Thread.currentThread()) {
            currentThread = null;
        }
    }
}

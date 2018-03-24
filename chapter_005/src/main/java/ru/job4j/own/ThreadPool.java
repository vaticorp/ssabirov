package ru.job4j.own;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * This class represents
 * @author Svyatoslav Sabirov.
 * @since 18.03.2018
 * @version 7.
 */
@ThreadSafe
public class ThreadPool {

    @GuardedBy("this")
    private final List<Work> works = new ArrayList<Work>();
    private final int processors = Runtime.getRuntime().availableProcessors();

    public void activatePool() {
        for (int index = 0; index < processors; index++) {
            new Thread() {
                @Override
                public void run() {
                    while (!Thread.currentThread().isInterrupted()) {
                        Work work = null;
                        synchronized (works) {
                            if (works.size() > 0) {
                                System.out.println("Работает поток: " + Thread.currentThread().getName());
                                work = works.remove(0);
                            }
                        }
                        if (work != null) {
                            work.doWork();
                        }
                    }
                }
            }.start();
        }
    }

    public void add(Work work) {
        synchronized (this.works) {
            works.add(work);
        }
    }
}

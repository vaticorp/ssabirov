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
    private List<Work> works = new ArrayList<Work>();

    public ThreadPool() {
        int processors = Runtime.getRuntime().availableProcessors();
        for (int index = 0; index < processors; index++) {
            new Thread() {
                @Override
                public void run() {
                    while (!Thread.currentThread().isInterrupted()) {
                        synchronized (works) {
                            if (works.size() > 0) {
                                System.out.println("Работает поток: " + Thread.currentThread().getName());
                                Work work = works.get(0);
                                work.doWork();
                                works.remove(work);
                            }
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

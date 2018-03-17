package ru.job4j.jmm;

import java.awt.*;


/**
 * This class represents Problem.
 * @author Svyatoslav Sabirov.
 * @since 17.03.2018
 * @version 7.
 */
public class Problem {

    Change innerChanger;
    private int divider = 1;

    public Problem(Change innerChanger) {
        this.innerChanger = innerChanger;
    }

    public Problem() {
        this(new Change(1));
    }

    //1) Race condition
    public void checkDivide() {
        new Thread() {
            @Override
            public void run() {
                int result = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    if (divider != 0) {
                        try {
                            Thread.sleep(100);
                            result = 100 / divider;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }
    public void reverseDivider() {
        new Thread() {
            @Override
            public void run() {
                int result = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    for (int index = result; index < 1000; index++) {
                        divider = index % 5;
                    }
                    result = 0;
                }
            }
        }.start();
    }

    //2) Visibility Of Shared Objects
    public void changeValue() {
        new Thread() {
            @Override
            public void run() {
                innerChanger.setValue(5);
                System.out.println("Поток 1 поменял значение потока на 5");
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    public void readValue() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Поток 2 прочитал значение " + innerChanger.getValue());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}


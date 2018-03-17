package ru.job4j.threads;

import java.util.Scanner;

public class CountChar implements Runnable {
    @Override
    public void run() {
        String newString = "Тут должен быть очень большой пример на использование";
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
             System.out.println("Всего символов в с строке: " +  newString.toCharArray().length);
        }
        System.out.println("Конец работы нити по подсчету символов");
    }
}

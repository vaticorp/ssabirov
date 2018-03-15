package ru.job4j.threads;

/**
 * This class represents simple example of paralelism.
 * @author Svyatoslav Sabirov.
 * @since 15.03.2018
 * @version 7.
 */
public class Asinhron {

    public void count(String phrase) {

        Thread spaceTread = new Thread() {
            @Override
            public void run() {
                char[] charArray = phrase.toCharArray();
                int result = 0;
                for (int index = 0; index < charArray.length; index++) {
                    if (charArray[index] == ' ') {
                        result++;
                    }
                }
                System.out.printf("\nThread 1: количество пробелов %d", result);
            }
        };
        Thread wordThread = new Thread() {
            @Override
            public void run() {
                char[] charArray = phrase.toCharArray();
                int result = 0;
                boolean word = false;
                for (int index = 0; index < charArray.length; index++) {
                    if (charArray[index] != ' ') {
                        word = true;
                    } else {
                        if (word) {
                            result++;
                            word = false;
                        }
                    }
                }
                if (word) {
                    result++;
                }
                System.out.printf("\nThread 2: количество слов %d", result);
            }
        };
        spaceTread.start();
        wordThread.start();
    }
}

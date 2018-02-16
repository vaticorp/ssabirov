package ru.job4j.task;

import java.util.Arrays;

/**
 *This is class for Coffee machine.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 16.02.2018
 */
public class CoffeeMachine {
    int[] changes(int value, int price) {
        int[] changes = new int[0];
        int change = value - price;
        while (change != 0) {
            int number = 0;
            if ((change - 10) >= 0) {
                number = 10;
            } else if ((change - 5) >= 0) {
                number = 5;
            } else if ((change - 2) >= 0) {
                number = 2;
            } else {
                number = 1;
             }
            change -= number;
            int[] temp = Arrays.copyOf(changes, changes.length);
            changes = new int[temp.length + 1];
            changes = Arrays.copyOf(temp, changes.length); // или System.arraycopy производительнее?
            changes[changes.length - 1] = number;
        }
        return changes;
    }
}

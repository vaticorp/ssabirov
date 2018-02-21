package ru.job4j.task;

import java.util.Arrays;

/**
 *This is class for Coffee machine.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 16.02.2018
 */
public class CoffeeMachine {
    //возможные номиналы
    private final int[] coins = new int[]{10, 5, 2, 1};

    int[] changes(int value, int price) {
        int[] changes = new int[0];
        int change = value - price;
        while (change != 0) {
            int number = 0;
            for (int index = 0; index < coins.length; index++) {
                number = coins[index];
                if ((change - number) >= 0) {
                    break;
                }
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

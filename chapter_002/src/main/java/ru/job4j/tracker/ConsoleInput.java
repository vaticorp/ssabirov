package ru.job4j.tracker;

import java.util.*;

/**
 * This class for all input command.
 * @author Svytoslav Sabirov.
 * @since 04.02.2018.
 * @version $id$.
 */
public class ConsoleInput implements Input {
    //Наш объект для ввода данных
    private Scanner sc = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return sc.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {

        int key = Integer.parseInt(this.ask(question));
        boolean exit = false;

        for (int value:range) {
            if (key == value) {
                exit = true;
                break;
            }
        }
        if (exit) {
            return key;
        } else {
            throw new MenuOutException("You must select a value from the menu range. Try again. ");
        }
    }
}

package io.manager.inputs;

import java.util.Scanner;

/**
 * This class represents class for input.
 * @author Svyatoslav Sabirov.
 * @since 11.08.2018
 * @version 7.
 */
public class ConsoleInput implements Input{

    private Scanner sc = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return sc.nextLine();
    }

    @Override
    public int ask(String question, int size) {
        int key = Integer.parseInt(this.ask(question));
        if (key > size) {
            throw  new IllegalSizeException("Выбран неправильный размер пункт меню!");
        }
        return key;
    }
}

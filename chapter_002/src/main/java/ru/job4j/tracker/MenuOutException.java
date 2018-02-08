package ru.job4j.tracker;

/**
 * This is class for our own exception
 * @author Svytoslav Sabirov.
 * @since 08.02.2018.
 * @version $id$.
 */
public class MenuOutException extends RuntimeException {

    public MenuOutException(String msg) {
        super(msg);
    }
}

package ru.job4j.tracker;

/**
 * Interface for menu.
 * @author Svyatoslav Sabirov.
 * @since 07.02.2018.
 * @version $id$.
 */
public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}

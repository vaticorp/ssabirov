package ru.job4j.own;

/**
 * This class represents simple action.
 * @author Svyatoslav Sabirov.
 * @since 18.03.2018
 * @version 7.
 */
public class Work  {

    private String action;

    public Work(String action) {
        this.action = action;
    }

    public void doWork() {
        System.out.println("Выполняется работа: " + this.action);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

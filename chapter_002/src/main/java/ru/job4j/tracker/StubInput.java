package ru.job4j.tracker;

/**
 * This is class for emulation executing program.
 * @author Svyatoslav Sabirov.
 * @since 05.02.2018.
 * @version $id$.
 */
public class StubInput implements Input {

    private final String[] value;

    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
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


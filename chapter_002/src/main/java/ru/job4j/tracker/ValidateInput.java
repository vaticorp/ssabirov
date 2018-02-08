package ru.job4j.tracker;

/**
 * This is validate-class.
 * @author Svytoslav Sabirov.
 * @since 08.02.2018.
 * @since $id$.
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {

        boolean invalidate = true;
        int result = -1;

        do {
            try {
                result = this.input.ask(question, range);
                invalidate = false;
            } catch (MenuOutException exc) {
                System.out.println("You must select a value from the menu range. Try again. ");
            } catch (NumberFormatException exc) {
                System.out.println("Please enter validate date again.");
            }
        }
        while (invalidate);
        return result;
    }
}

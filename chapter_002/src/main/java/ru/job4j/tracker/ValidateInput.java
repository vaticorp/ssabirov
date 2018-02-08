package ru.job4j.tracker;

/**
 * This is validate-class.
 * @author Svytoslav Sabirov.
 * @since 08.02.2018.
 * @since $id$.
 */
public class ValidateInput extends ConsoleInput {

    public int ask(String question, int[] range) {

        boolean invalidate = true;
        int result = -1;

        do {
            try {
                result = super.ask(question, range);
                invalidate = false;
            } catch (MenuOutException exc) {
                System.out.println("You must select a value from the menu range. Try again. ");
            } catch (NumberFormatException exc) {
                System.out.println("Please enter validate date again. ");
            }
        }
        while (invalidate);
        return result;
    }
}

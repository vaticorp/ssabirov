package menu.actions;

import menu.actions.MenuAction;

/**
 * This class represents simple summrise of two numbers.
 * @author Svyatoslav Sabirov.
 * @since 27.07.2018
 * @version 9.
 */
public class AddTwoNumbers implements MenuAction {

    @Override
    public String description() {
        return "Действие служит для сложения 2 чисел";
    }

    @Override
    public void execute() {
        System.out.println(String.format("2 + 5 is %d", 7));
    }
}

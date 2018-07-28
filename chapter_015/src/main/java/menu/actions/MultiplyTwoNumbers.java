package menu.actions;

/**
 * This class represents multiply of two numbers.
 * @author Svyatoslav Sabirov.
 * @since 27.07.2018
 * @version 7.
 */
public class MultiplyTwoNumbers implements MenuAction{

    @Override
    public String description() {
        return "Действие служит для умножения 2 чисел";
    }

    @Override
    public void execute() {
        System.out.println(String.format("2 * 5 is %d", 10));
    }
}

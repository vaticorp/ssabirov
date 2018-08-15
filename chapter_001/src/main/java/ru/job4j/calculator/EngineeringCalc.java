package ru.job4j.calculator;
import ru.job4j.calculator.operations.Cosinus;
import ru.job4j.calculator.operations.Sinus;
import ru.job4j.calculator.operations.Tangens;

/**
 * This class represents class for engineering calculator.
 * @author Svyatoslav Sabirov.
 * @since 25.07.2018
 * @version 7.
 */
public class EngineeringCalc extends InteractCalc {

    public EngineeringCalc(Calculator calculator) {
        super(calculator);
        addOperation(new Cosinus(calculator));
        addOperation(new Sinus(calculator));
        addOperation(new Tangens(calculator));
    }

    public static void main(String[] args) {
        InteractCalc interactCalc = new EngineeringCalc(new Calculator());
        interactCalc.start();
    }
}


package ru.job4j.calculator;

import ru.job4j.calculator.operations.*;

import java.util.*;

/**
 * This class represents class for input.
 * @author Svyatoslav Sabirov.
 * @since 24.07.2018
 * @version 9.
 */
public class InteractCalc {

    protected final Calculator calculator;
    private final Scanner sc = new Scanner(System.in);
    protected final HashMap<String, Operation> validOperations = new HashMap<>();

    public InteractCalc(Calculator calculator) {
        this.calculator = calculator;
    }

    void addOperation(Operation operation) {
        validOperations.put(operation.getName(), operation);
    }

    public String action(String question) {
        System.out.println(question);
        return sc.nextLine();
    }

    public void select(String query) {
        Operation operation = validOperations.get(query);
        if (operation == null) {
            System.out.println("Необходимо выбирать корректное действие!");
            return;
        }
        double secondValue = Double.parseDouble(action("Введите число: "));
        operation.execute(calculator.getResult(), secondValue);
        //execute(query,secondValue);
        System.out.println(String.format("Текущее значение: %s", calculator.getResult()));
    }

    public void start() {
        while (true) {
            String answer = this.action("Введите действие(для выхода - stop) : ");
            if (answer.equals("stop")) {
                break;
            }
            select(answer);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        InteractCalc interactCalc = new InteractCalc(calculator);
        interactCalc.addOperation(new Add(calculator));
        interactCalc.addOperation(new Subtract(calculator));
        interactCalc.addOperation(new Multiple(calculator));
        interactCalc.addOperation(new Div(calculator));
        interactCalc.start();
    }
}

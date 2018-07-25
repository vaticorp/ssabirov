package ru.job4j.calculator;

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
    protected final ArrayList<String> validOperations = new ArrayList<String>();

    public InteractCalc(Calculator calculator) {
        this.calculator = calculator;
        Collections.addAll(validOperations, "+", "-", "*", "/");
    }

    public String action(String question) {
        System.out.println(question);
        return sc.nextLine();
    }

    public void select(String query) {
        if (!validOperations.contains(query)) {
            System.out.println("Необходимо выбирать корректное действие!");
            return;
        }
        double secondValue = Double.parseDouble(action("Введите число: "));
        execute(query,secondValue);
        System.out.println(String.format("Текущее значение: %s", calculator.getResult()));
    }

    public void execute(String query,double secondValue) {
        if (query.equals("+")){
            calculator.add(calculator.getResult(), secondValue);
        } else if (query.equals("-")) {
            calculator.subtract(calculator.getResult(), secondValue);
        } else if (query.equals("*")) {
            calculator.multiple(calculator.getResult(), secondValue);
        } else if (query.equals("/")) {
            calculator.div(calculator.getResult(), secondValue);
        }
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
        interactCalc.start();
    }
}

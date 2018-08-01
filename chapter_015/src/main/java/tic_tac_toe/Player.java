package tic_tac_toe;

import java.util.Scanner;

/**
 * This class represents player.
 * @author Svyatoslav Sabirov.
 * @since 30.07.2018
 * @version 7.
 */
public class Player implements BasePlayer,Input {

    private String label;
    private Cell[][] cells;
    private final Scanner sc = new Scanner(System.in);

    public Player(String label, Cell[][] cells) {
        this.label = label;
        this.cells = cells;
    }

    @Override
    public String toString() {
        return "Player{" +
                "label='" + label + '\'' +
                '}';
    }

    @Override
    public Cell makeMove() {
        Cell newMove = null;
        System.out.println(String.format("Ходит игрок %s", this));
        while (true) {
            int x = Integer.parseInt(ask("Введите x: "));
            int y = Integer.parseInt(ask("Введите y: "));
            if (cells[x][y] == null) {
                newMove = new Cell(x, y, getLabel());
                cells[x][y] = newMove;
                break;
            }
            System.out.println("Клетка занята! Введите новое значение");
        }
        return newMove;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String ask(String question) {
        System.out.println(question);
        return sc.nextLine();
    }
}

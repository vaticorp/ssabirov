package ru.job4j.chess;

import ru.job4j.chess.figures.Bishop;

/**
 * This our main class for staring game
 * @author Svyatoslav Sabirov.
 * @since 11.02.2018.
 * @version $id$.
 */
public class StartGame {

    public static void init() {
        Bishop bishop = new Bishop(new Cell(5, 3));
        try {
            Cell[] cells = bishop.way(new Cell(5, 3), new Cell(2, 6));
            for (Cell cell: cells) {
                System.out.println(cell.getX() + " " + cell.getY());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        StartGame.init();
        //Cell cell = new Cell(2, 6);
    }
}



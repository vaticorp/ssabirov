package tic_tac_toe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class represents
 * @author Svyatoslav Sabirov.
 * @since 30.07.2018
 * @version 7.
 */
public class Game implements GameActions {

    private BasePlayer firstPlayer;
    private BasePlayer secondPlayer;
    private boolean finish = false;
    private Cell[][] cells;

    public Game(BasePlayer firstPlayer, BasePlayer secondPlayer, Cell[][] cells) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.cells = cells;
    }

    @Override
    public void startGame() {
        boolean result = false;
        List<BasePlayer> list = new ArrayList<BasePlayer>();
        Collections.addAll(list, firstPlayer, secondPlayer);
        while (true) {
            for (BasePlayer basePlayer : list) {
                draw();
                Cell last = basePlayer.makeMove();
                if (checkMove(last)) {
                    System.out.println(String.format("Игра окончена! Победил игрок %s", basePlayer));
                    draw();
                    return;
                }
            }
        }
    }

    /**
     * Метод проверяет выиграл ли игрок по последнему ходу.
     * Для этого достаточно проверить 3 варианта: по горизонтали,по вертикали,по диагонали
     * @param lastMove - последний ход игрока.
     * @return - закончена ли игра.
     */
    @Override
    public boolean checkMove(Cell lastMove) {
        String label = lastMove.getLabel();
        int x = lastMove.getX();
        int y = lastMove.getY();
        boolean resultRow = checkRow(x, label);
        boolean resultColumn = checkColumn(y, label);
        boolean resultDiagonal = (x == y)? checkDiagonal(label) : false;
        return resultRow || resultColumn || resultDiagonal;
    }

    public boolean checkRow(int x, String label) {
        boolean result = true;
        for (int i=0; i < cells.length; i++) {
            if (cells[x][i]== null || cells[x][i].getLabel().equals(label)==false) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean checkColumn(int y, String label) {
        boolean result = true;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][y]== null || cells[i][y].getLabel().equals(label)==false) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean checkDiagonal(String label) {
        boolean result = true;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][i]== null || cells[i][i].getLabel().equals(label)==false) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void draw() {
        for (int x = 0; x < this.cells.length; x++ ) {
            System.out.print("\n|");
            for (int y = 0; y < this.cells.length; y++ ) {
                Cell cell = cells[x][y];
                System.out.print(String.format("%s|", (cell == null)? "_" : cell.getLabel()));
            }
        }
        System.out.print("\n");
    }
}

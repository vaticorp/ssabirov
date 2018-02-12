package ru.job4j.chess;

/**
 * This class for position on board 8x8.
 * @author Svyatoslav Sabirov.
 * @since 10.02.2018.
 * @version $id$.
 */
public class Cell {

    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

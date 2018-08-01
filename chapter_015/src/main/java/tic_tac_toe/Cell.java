package tic_tac_toe;

/**
 * This class represents simple Cell.
 * @author Svyatoslav Sabirov.
 * @since 30.07.2018
 * @version 7.
 */
public class Cell {

    private int x;
    private int y;
    private String label;

    public Cell(int x, int y, String label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

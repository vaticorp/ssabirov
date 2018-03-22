package ru.job4j.bomber;

/**
 * This class represents Pair.
 * @author Svyatoslav Sabirov.
 * @since 22.03.2018
 * @version 7.
 */
public class Pair {

    private int x;
    private int y;
    private final int boardSizeX;
    private final int boardSizeY;

    /**
     * Констурктор создания пары. При создании объекты сразу вычисляем положение на игровом поле.
     * @param boardSizeX - размер поля по горизонтали.
     * @param boardSizeY - поля по вертикали.
     */
    public Pair(int boardSizeX, int boardSizeY) {
        this.boardSizeX = boardSizeX;
        this.boardSizeY = boardSizeY;
        this.x = (int) Math.random() * boardSizeX + 1;
        this.y = (int) Math.random() * boardSizeY + 1;
    }

    /**
     * Конструктор пары,когда вычислять ничего не надо
     * @param boardSizeX - размер поля по горизонтали.
     * @param boardSizeY - размер поля по вертикали.
     * @param x - положение по горзинтали.
     * @param y - положение по вертикали.
     */
    public Pair(int boardSizeX, int boardSizeY, int x, int y) {
        this.boardSizeX = boardSizeX;
        this.boardSizeY = boardSizeY;
        this.x = x;
        this.y = y;
    }

    public int getBoardSizeX() {
        return boardSizeX;
    }

    public int getBoardSizeY() {
        return boardSizeY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return x;
    }

    public void setX(int x) {
        x = x;
    }

    public void setY(int y) {
        y = y;
    }

    /**
     * Метод вычисляет потениально возможный ход из текущей позиции.
     * @param sizeX - размер доски по горизонтали.
     * @param sizeY - размер доски по вертикали.
     * @param positionX - положение по горизонтали.
     * @param positionY - положение по вертикали.
     * @return
     */
    public static Pair calculateMove(int sizeX, int sizeY, int positionX, int positionY) {
        int sign = (int) (Math.random() * 100) >= (int) (Math.random() * 100) ? 1 : -1;
        //при выполнении этого условия будет горизонтальное перемещение
        if ((int) (Math.random() * 100) >= (int) (Math.random() * 100)) {
            if (positionX == 0) {
                positionX++;
            } else if (positionX == sizeX - 1) {
                positionX--;
            } else {
                positionX += sign;
            }
        } else {
            if (positionY == 0) {
                positionY++;
            } else if (positionY == sizeY - 1) {
                positionY--;
            } else {
                positionY += sign;
            }
        }
        return new Pair(sizeX, sizeY, positionX, positionY);
    }
}
package ru.job4j.bomber;

import java.util.ArrayList;

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
        this.x = (int) (Math.random() * boardSizeX);
        this.y = (int) (Math.random() * boardSizeY);
        System.out.println("Персонаж размечен в позиции: x = " + this.x + " y = " + this.y);
    }

    /**
     * Конструктор пары,когда вычислять ничего не надо
     * @param boardSizeX - размер поля по горизонтали.
     * @param boardSizeY - размер поля по вертикали.
     * @param xValue - положение по горзинтали.
     * @param yValue - положение по вертикали.
     */
    public Pair(int boardSizeX, int boardSizeY, int xValue, int yValue) {
        this.boardSizeX = boardSizeX;
        this.boardSizeY = boardSizeY;
        this.x = xValue;
        this.y = yValue;
    }

    public int getBoardSizeX() {
        return boardSizeX;
    }

    public int getBoardSizeY() {
        return boardSizeY;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int xValue) {
        this.x = xValue;
    }

    public void setY(int yValue) {
        this.y = yValue;
    }

    /**
     * Метод вычисляет потениально возможный ход из текущей позиции.
     * @param sizeX - размер доски по горизонтали.
     * @param sizeY - размер доски по вертикали.
     * @param positionX - положение по горизонтали.
     * @param positionY - положение по вертикали.
     * @return
     */
    public static Pair calculateMove(int sizeX, int sizeY, int positionX, int positionY, ArrayList<Pair> forbiddenCells) {
        boolean condition;
        int newPositionX;
        int newPositionY;
        do {
            condition = true;
            newPositionX = positionX;
            newPositionY = positionY;
            int sign = (int) (Math.random() * 100) >= (int) (Math.random() * 100) ? 1 : -1;
            //при выполнении этого условия будет горизонтальное перемещение
            if ((int) (Math.random() * 100) >= (int) (Math.random() * 100)) {
                if (newPositionX == 0) {
                    newPositionX++;
                } else if (newPositionX == sizeX - 1) {
                    newPositionX--;
                } else {
                    newPositionX += sign;
                }
            } else {
                if (newPositionY == 0) {
                    newPositionY++;
                } else if (newPositionY == sizeY - 1) {
                    newPositionY--;
                } else {
                    newPositionY += sign;
                }
            }
            for (Pair currentPair : forbiddenCells) {
                if (currentPair.getX() == newPositionX && currentPair.getY() == newPositionY) {
                    condition = false;
                    break;
                }
            }
        } while (!condition);
        return new Pair(sizeX, sizeY, newPositionX, newPositionY);
    }
}
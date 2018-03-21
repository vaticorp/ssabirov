package ru.job4j.bomber;

import net.jcip.annotations.ThreadSafe;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class represents Bomberman.
 * @author Svyatoslav Sabirov.
 * @since 21.03.2018
 * @version 9.
 */
@ThreadSafe
public class Bomberman {

    private final ReentrantLock[][] board;
    private final int numberOfMonsters;
    private final int sizeX;
    private final int sizeY;
    private boolean gameOver = false;
    private final Thread hero = new Thread() {
        @Override
        public void run() {
            int positionX = (int) Math.random() * sizeX + 1;
            int positionY = (int) Math.random() * sizeY + 1;
            int duration;
            while (!gameOver) {
                Pair newMove = calculateMove(positionX, positionY);
                board[positionX][positionY] = new ReentrantLock();
                duration = !board[positionX][positionY].tryLock()? 500 : 1000;
                if (duration == 1000)
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    board[positionX][positionY].unlock();
                }
                if (duration == 1000) {
                    positionX = newMove.getX();
                    positionY = newMove.getY();
                    System.out.println("Покидаю ячейку x = " + positionX + " y = " + positionY);
                }
            }
        }
    };

    public Bomberman(int boardSizeX,int boardSizeY, int monsters) {
        this.sizeX = boardSizeX;
        this.sizeY = boardSizeY;
        board = new ReentrantLock[boardSizeX][boardSizeY];
        this.numberOfMonsters = monsters;
    }

    private Pair calculateMove(int positionX, int positionY) {

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
        return new Pair(positionX, positionY);
    }

    /**
     * Начнем игру: запустить персонажа,запустить n-монстров
     */
    public void startGame() {
        hero.start();
        /*
        for (int index = 0; index < this.numberOfMonsters; index++) {
            new Thread() {
                //опишем ходы монстров и запустим их ходьбу
            }.start();
        }*/
    }

    public class Pair {

        private int X;
        private int Y;

        public Pair(int x, int y) {
            X = x;
            Y = y;
        }

        public int getX() {
            return X;
        }

        public int getY() {
            return Y;
        }
    }

    public static void main(String[] args) {
        Bomberman newGame = new Bomberman(20, 20, 1);
        newGame.startGame();
    }
}


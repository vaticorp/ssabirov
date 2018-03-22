package ru.job4j.bomber;

import java.util.concurrent.locks.ReentrantLock;

/**
 * This class represents Hero.
 * @author Svyatoslav Sabirov.
 * @since 22.03.2018
 * @version 9.
 */
public class Hero extends Thread {

    private final ReentrantLock[][] board;
    private final Pair position;

    public Hero(int sizeX, int sizeY, ReentrantLock[][] board) {
        this.board = board;
        this.position = new Pair(sizeX, sizeY);
    }

    @Override
    public void run() {
        int duration;
        while (!isInterrupted()) {
            int positionX = position.getX();
            int positionY = position.getY();
            Pair newMove = Pair.calculateMove(position.getBoardSizeX(), position.getBoardSizeY(), positionX, positionY);
            board[positionX][positionY] = new ReentrantLock();
            duration = !board[positionX][positionY].tryLock() ? 500 : 1000;
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                board[positionX][positionY].unlock();
            }
            if (duration == 1000) {
                position.setX(newMove.getX());
                position.setY(newMove.getY());
                System.out.println("Покидаю ячейку x = " + position.getX() + " y = " + position.getY());
            }
        }
    }
}

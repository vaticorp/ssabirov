package ru.job4j.bomber;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class represents Hero.
 * @author Svyatoslav Sabirov.
 * @since 22.03.2018
 * @version 9.
 */
public class Hero extends Thread {

    private final Pair position;
    private final Bomberman game;

    public Hero(String name, Bomberman game) {
        super(name);
        this.game = game;
        this.position = new Pair(game.getSizeX(), game.getSizeY());
    }

    @Override
    public void run() {
        boolean lockResult;
        ReentrantLock[][] board;
        while (!game.isGameOver()) {
            lockResult = false;
            int positionX = position.getX();
            int positionY = position.getY();
            board = game.getBoard();
            Pair newMove = Pair.calculateMove(position.getBoardSizeX(), position.getBoardSizeY(), positionX, positionY, game.getObstacles());
            ReentrantLock lock = board[newMove.getX()][newMove.getY()];
            try {
                lockResult = lock.tryLock(500, TimeUnit.MILLISECONDS);
                if (lockResult) {
                    position.setX(newMove.getX());
                    position.setY(newMove.getY());
                    System.out.println(Thread.currentThread().getName() + " перешел в ячейку x = " + position.getX() + " y = " + position.getY());
                    Thread.sleep(1000);
                } else {
                    System.out.println(Thread.currentThread().getName() + " попал в лапы монстра! Игра окончена");
                    game.setGameOver(true);
                    continue;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lockResult) {
                    lock.unlock();
                }
            }
        }
    }
}

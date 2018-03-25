package ru.job4j.bomber;

import java.util.ArrayList;
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
        int duration;
        ReentrantLock[][] board;
        while (!game.isGameOver()) {
            int positionX = position.getX();
            int positionY = position.getY();
            board = game.getBoard();
            Pair newMove = Pair.calculateMove(position.getBoardSizeX(), position.getBoardSizeY(), positionX, positionY, game.getObstacles());
            ReentrantLock lock = board[newMove.getX()][newMove.getY()];
            duration = !board[newMove.getX()][newMove.getY()].tryLock() ? 500 : 1000;
            if (duration == 1000) {
                position.setX(newMove.getX());
                position.setY(newMove.getY());
                System.out.println(Thread.currentThread().getName() + " перешел в ячейку x = " + position.getX() + " y = " + position.getY());
            } else {
                System.out.println("Персонаж попался в лапы монстру! Игра окончена");
                game.setGameOver(true);
                continue;
            }
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (duration == 1000) {
                    board[newMove.getX()][newMove.getY()].unlock();
                }
            }
        }
    }
}

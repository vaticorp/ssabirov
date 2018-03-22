package ru.job4j.bomber;

import net.jcip.annotations.GuardedBy;
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

    @GuardedBy("this")
    private final ReentrantLock[][] board;
    private final int numberOfMonsters;
    private final int sizeX;
    private final int sizeY;

    public Bomberman(int boardSizeX, int boardSizeY, int monsters) {
        this.sizeX = boardSizeX;
        this.sizeY = boardSizeY;
        board = new ReentrantLock[boardSizeX][boardSizeY];
        this.numberOfMonsters = monsters;
    }
    /**
     * Начнем игру: запустить персонажа,запустить n-монстров
     */
    public void startGame() {
        Hero hero = new Hero(sizeX, sizeY, board);
        hero.start();
        /*
        for (int index = 0; index < this.numberOfMonsters; index++) {
            new Thread() {
                //опишем ходы монстров и запустим их ходьбу
            }.start();
        }*/
    }

    public static void main(String[] args) {
        Bomberman newGame = new Bomberman(20, 20, 1);
        newGame.startGame();
    }
}


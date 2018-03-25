package ru.job4j.bomber;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
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
    private final ArrayList<Pair> obstacles;
    private final Hero mario;
    private boolean gameOver = false;

    public Bomberman(int boardSizeX, int boardSizeY, int monsters, ArrayList<Pair> obstacles) {
        this.sizeX = boardSizeX;
        this.sizeY = boardSizeY;
        board = new ReentrantLock[boardSizeX][boardSizeY];
        for (int i = 0; i < boardSizeX; i++) {
            for (int j = 0; j < boardSizeY; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
        this.numberOfMonsters = monsters;
        this.obstacles = obstacles;
        this.mario = new Hero("Mario", this);
    }

    public Hero getMario() {
        return mario;
    }

    public ArrayList<Pair> getObstacles() {
        return obstacles;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public ReentrantLock[][] getBoard() {
        return board;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    /**
     * Начнем игру: запустить персонажа,запустить n-монстров
     */
    public void startGame() {
        mario.start();
        for (int index = 0; index < this.numberOfMonsters; index++) {
            new Monster("Монстр " + index, this).start();
        }
    }

    public static void main(String[] args) {
        ArrayList<Pair> barriers = new ArrayList<Pair>();
        barriers.add(new Pair(8, 8, 0, 0));
        barriers.add(new Pair(8, 8, 0, 3));
        barriers.add(new Pair(8, 8, 3, 0));
        barriers.add(new Pair(8, 8, 3, 3));
        Bomberman newGame = new Bomberman(8, 8, 2, barriers);
        newGame.startGame();
    }
}


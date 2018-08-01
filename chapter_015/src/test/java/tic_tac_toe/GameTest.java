package tic_tac_toe;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class GameTest {
    @Test
    public void whenStartSimpleGame() {
        Cell[][] cells = new Cell[4][4];
        BasePlayer people = new Player("X", cells);
        BasePlayer computer = new AIPlayer("O", cells);
        Game newGame = new Game(people, computer, cells);
        newGame.startGame();
    }
}
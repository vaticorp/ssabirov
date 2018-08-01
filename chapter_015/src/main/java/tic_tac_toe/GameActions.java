package tic_tac_toe;

/**
 * This class represents interface for game;
 * @author Svyatoslav Sabirov.
 * @since 30.07.2018
 * @version 7.
 */
public interface GameActions  {
    void startGame();
    boolean checkMove(Cell lastMove);
    void draw();
}

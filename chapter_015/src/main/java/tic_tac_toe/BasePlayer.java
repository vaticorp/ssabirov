package tic_tac_toe;

/**
 * This class represents interface for player.
 * @author Svyatoslav Sabirov.
 * @since 30.07.2018
 * @version 7.
 */
public interface BasePlayer {
    Cell makeMove();
    String getLabel();
}

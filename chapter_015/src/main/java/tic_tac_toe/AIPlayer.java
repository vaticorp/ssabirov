package tic_tac_toe;

/**
 * This class represents computer-player.
 * @author Svyatoslav Sabirov.
 * @since 30.07.2018
 * @version 7.
 */
public class AIPlayer implements BasePlayer {

    private Player player;
    private String label;
    private Cell[][] cells;

    public AIPlayer(Player player) {
        this.player = player;
    }

    public AIPlayer(String label, Cell[][] cells) {
        this.label = label;
        this.cells = cells;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public Cell makeMove() {
        Cell newMove = null;
        System.out.println(String.format("Ходит игрок %s", this));
        while (true) {
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);
            if (cells[x][y] == null) {
                newMove = new Cell(x, y, getLabel());
                cells[x][y] = newMove;
                break;
            }
            System.out.println("Клетка занята! Введите новое значение");
        }
        return newMove;
    }

    @Override
    public String getLabel() {
        return label;
    }
}

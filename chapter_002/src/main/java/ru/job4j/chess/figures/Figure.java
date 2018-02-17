package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.ImposibleMoveException;

/**This is abstract class for figure.
 * @author Svyatoslav Sabirov.
 * @since 10.02.2018
 * @version $id$.
 */
public abstract class Figure {

    final Cell position;

    public Figure(Cell cellposition) {
        position = cellposition;
    }

    public boolean figureInCell(Cell source) {
        return (source.getX() == position.getX() && source.getY() == position.getY());
    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;
    public abstract Figure copy(Cell dest);
}

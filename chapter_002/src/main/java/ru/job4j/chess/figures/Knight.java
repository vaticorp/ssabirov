package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.ImposibleMoveException;

/**
 * This is class for Knight-figure.
 * @author Svyatoslav Sabirov.
 * @since 12.02.2018.
 * @version $id$.
 */
public class Knight extends Figure {

    public Knight(Cell cellposition) {
        super(cellposition);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        return new Cell[0];
    }

    @Override
    Figure copy(Cell dest) {
        return null;
    }
}

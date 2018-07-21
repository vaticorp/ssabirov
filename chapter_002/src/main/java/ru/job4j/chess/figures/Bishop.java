package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.ImposibleMoveException;

import java.util.function.Function;

/**
 * This class represents class for Bishop-figure.
 * @author Svyatoslav Sabirov.
 * @since 21.07.2018
 * @version 10.
 */
public class Bishop extends Figure {

    public Bishop(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        Cell[] allWay = wayLambda(source, dest, difference -> {
            Cell[] all = new Cell[difference];
            for (int index = 0; index < difference; index++) {
                int coordinateX = source.getX() < dest.getX() ? source.getX() + index + 1 : source.getX() - index - 1;
                int coordinateY = source.getY() < dest.getY() ? dest.getY() + index + 1 : source.getY() - index - 1;
                all[index] = new Cell(coordinateX, coordinateY);
            }
            return all;
        });
        return allWay;
    }

    public Cell[] wayLambda(Cell source, Cell dest, Function<Integer, Cell[]> command) throws ImposibleMoveException {
        int sourceX = source.getX();
        int sourceY = source.getY();
        int destX = dest.getX();
        int destY = dest.getY();
        int difference = Math.abs(sourceX - destX);
        if ((sourceY + difference) != destY && (sourceY - difference) != destY) {
            throw new ImposibleMoveException("You can not move a shape to this cell");
        }
        return command.apply(difference);
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}

package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.ImposibleMoveException;
import ru.job4j.chess.figures.Figure;

public class Bishop extends Figure {

    public Bishop(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {

        int sourcex = source.getX();
        int sourcey = source.getY();
        int destx = dest.getX();
        int desty = dest.getY();
        int difference = Math.abs(sourcex - destx);
        Cell[] allWay = new Cell[difference];

        if ((sourcey + difference) != desty && (sourcey - difference) != desty) {
            throw new ImposibleMoveException("You can not move a shape to this cell");
        //fill our way array.
        } else {
            for (int index = 0; index < difference; index++) {
                int coordinateX = sourcex < destx ? sourcex + index + 1 : sourcex - index - 1;
                int coordinateY = sourcey < desty ? sourcey + index + 1 : sourcey - index - 1;
                allWay[index] = new Cell(coordinateX, coordinateY);
            }
        }
        return allWay;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}

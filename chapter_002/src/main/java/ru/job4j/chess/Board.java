package ru.job4j.chess;

import ru.job4j.chess.exceptions.*;
import ru.job4j.chess.figures.Bishop;
import ru.job4j.chess.figures.Figure;

/**
 * This is class for chess-board.
 * @author Svyatoslav Sabirov.
 * @since 10.02.2018.
 * @version $id$.
 */
public class Board{

    private int positionarray = 0;
    private Figure[] figures = new Figure[32];
    private final int sizex = 8;
    private final int sizey = 8;

    public void add(Figure figure) {
        figures[positionarray++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws  ImposibleMoveException, OccupiedWayException, FigureNotFoundException {

        Figure currentObject = null;
        Cell[] cells = null;

        for (Figure current: figures) {
            if (current.figureInCell(source)) {
                currentObject = current;
            }
        }
        if (currentObject == null) {
            throw new FigureNotFoundException("Figure not found!");
        }

        try {
            //Для каждой фигуры свой объект
            if (currentObject instanceof Bishop) {
                Bishop bishopFigure = (Bishop)currentObject;
                cells = bishopFigure.way(source, dest);
            }
        } catch (ImposibleMoveException e) {
            System.out.println(e);
            return false;
        }

        //Для коня проверяем только конечную ячейку
        if (currentObject instanceof Bishop) {
            if (currentObject.figureInCell(dest) == true) {
                throw new OccupiedWayException("The path is busy!");
            }
        } else {
            for (Cell currentCell : cells) {
                for (Figure current: figures) {
                    if (current.figureInCell(source)) {
                        throw new OccupiedWayException("The path is busy!");
                    }
                }
            }
        }


        return true;
    }

    public int getSizeX() {
        return sizex;
    }

    public int getSizeY() {
        return sizey;
    }
}



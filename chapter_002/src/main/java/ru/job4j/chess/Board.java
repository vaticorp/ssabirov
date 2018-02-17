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
    //Переменные класса
    private final int sizeX = 8;
    private final int sizeY = 8;
    private int position = 0;
    private Figure[] figures = new Figure[32];
    /**
     * Заполние доски доступными фигурами
     * @param figure - фигура.
     */
    public void add(Figure figure) {
        figures[position++] = figure;
    }
    /**
     * Движение фигуры из одной ячейки в другую.
     * @param source - исходное положение фигуры.
     * @param dest - конечное положение фигуры
     * @return - успешно ли передвижение
     * @throws ImposibleMoveException - недопустимое перемещение.
     * @throws OccupiedWayException - путь занят.
     * @throws FigureNotFoundException - фигура не найдена в ячейке.
     */
    public boolean move(Cell source, Cell dest) throws  ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        //проверяем на наличие фигуры
        Figure currentObject = findFigure(source);
        //проверяем достижимость пути
        Cell[] cells = currentObject.way(source, dest);
        //проверяем путь на занятость
        cellsAreFree(cells);
        //переносим фигуру
        Figure blackBishop = currentObject.copy(dest);
        add(blackBishop);
        return true;
    }
    public void cellsAreFree(Cell[] cells) throws OccupiedWayException{
        for (Cell currentCell : cells) {
            for (Figure current: figures) {
                if (current.figureInCell(currentCell)) {
                    throw new OccupiedWayException("The path is busy!");
                }
            }
        }
    }
    public Figure findFigure(Cell cell) throws FigureNotFoundException{
        Figure currentObject = null;
        for (Figure current: figures) {
            if (current.figureInCell(cell)) {
                currentObject = current;
            }
        }
        if (currentObject == null) {
            throw new FigureNotFoundException("Figure not found!");
        }
        return currentObject;
    }
    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
}



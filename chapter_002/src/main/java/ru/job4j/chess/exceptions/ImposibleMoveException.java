package ru.job4j.chess.exceptions;

/**
 * This class for our own Exception.
 * @author Svyatoslav Sabirov.
 * @version 10.02.2018.
 * @version $id$.
 */
public class ImposibleMoveException extends RuntimeException {

    public ImposibleMoveException(String message) {
        super(message);
    }
}

package tdd.exceptions;

/**
 * This class represents exception when we have extra key in map.
 * @author Svyatoslav Sabirov.
 * @since 28.07.2018
 * @version 7.
 */
public class ExtraKeyException extends RuntimeException {

    public ExtraKeyException(String message) {
        super(message);
    }
}

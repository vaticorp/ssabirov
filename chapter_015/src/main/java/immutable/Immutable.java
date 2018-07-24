package immutable;

/**
 * This interface represents simple Immutable list.
 * @author Svyatoslav Sabirov.
 * @since 24.07.2018
 * @version 7.
 */
public interface Immutable<T> extends Iterable<T> {
    T get(int index);
}

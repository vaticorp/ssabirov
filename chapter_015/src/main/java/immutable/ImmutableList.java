package immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * This class represents simple
 * @author Svyatoslav Sabirov.
 * @since 24.07.2018
 * @version 9.
 */
public class ImmutableList<E> implements Immutable<E> {

    private final ArrayList<E> container;

    public ImmutableList(final ArrayList<E> container) {
        this.container = container;
    }

    public int size() {
        return container.size();
    }

    /**
     * Get-final object.
     * @param index - index.
     * @return - value.
     */
    @Override
    public final E get(int index) {
        if (index > container.size() - 1) {
            throw new IndexOutOfBoundsException("Превышен максимальный индекс для элемента коллекции!");
        }
        return container.get(index);
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return this.hasNext();
            }

            @Override
            public final E next() {
                return this.next();
            }
        };
    }
}

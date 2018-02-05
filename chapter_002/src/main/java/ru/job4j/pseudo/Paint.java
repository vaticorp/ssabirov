package ru.job4j.pseudo;

/**
 * This class is show us Strategy-pattern.
 * @author Svyatoslav Sabirob.
 * @since 05.02.2018.
 * @version $id$.
 */
public class Paint {

    /**
     *This method will have different behavior.
     * @param shape - интерфейс.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}

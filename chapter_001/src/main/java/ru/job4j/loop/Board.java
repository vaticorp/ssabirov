package ru.job4j.loop;

/**
 * This is my first class with two loops.
 * @author Svytoslav Sabirov
 * @since 25.01.2018
 * @version $id$.
 */
public class Board {

    public String paint(int width, int height) {

        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                 if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }

}
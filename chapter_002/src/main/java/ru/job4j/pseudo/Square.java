package ru.job4j.pseudo;

/**
 * This class is implement interface and show us Strategy-pattern.
 * @author Svyatoslav Sabirob.
 * @since 05.02.2018.
 * @version $id$.
 */
public class Square implements Shape {

    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("********");
        pic.append("*      *");
        pic.append("*      *");
        pic.append("*      *");
        pic.append("*      *");
        pic.append("*      *");
        pic.append("*      *");
        pic.append("********");
        return pic.toString();
    }
}

package ru.job4j.firstinheritance;

/**
 * Class - successor.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 31.01.2018.
 */
public class Engineer extends Profession {

    public Engineer(boolean diploma, int age, String name) {
        super(diploma, age, name);
    }

    public void study() {

    }

    public void service(Teacher teacher) {

    }
}

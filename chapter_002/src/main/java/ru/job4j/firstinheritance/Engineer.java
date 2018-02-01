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
        System.out.println("Engineer getting new skills...");
    }

    public void service(Teacher teacher) {
        System.out.println(this.getName() + " serving " + teacher.getName());
    }
}

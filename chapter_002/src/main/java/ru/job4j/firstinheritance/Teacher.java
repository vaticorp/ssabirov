package ru.job4j.firstinheritance;

/**
 * Class - successor.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 31.01.2018.
 */
public class Teacher extends Profession {

    private int experience;

    public int getExperience() {
        return experience;
    }

    public Teacher(boolean diploma, int age, String name) {
        super(diploma, age, name);
    }

    public void teach(Doctor doctor) {
        System.out.println(this.getName() + " teaching " + doctor.getName());
    }

    public void selfstudy() {
        System.out.println("Teacher studying...");
    }

}

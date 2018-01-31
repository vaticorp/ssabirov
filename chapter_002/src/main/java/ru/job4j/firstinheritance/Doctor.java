package ru.job4j.firstinheritance;

/**
 * Class - successor.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 31.01.2018.
 */
public class Doctor extends Profession {

    private boolean degree;

    public boolean isDegree() {
        return degree;
    }

    public Doctor(boolean diploma, int age, String name) {
        super(diploma, age, name);
    }

    public Diagnose heal(Engineer engineer) {
        return new Diagnose("incognito");
    }

    public void relax() {

    }

}

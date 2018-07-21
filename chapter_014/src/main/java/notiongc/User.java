package notiongc;

import java.util.ArrayList;

/**
 * This class represents user-model.
 * @author Svyatoslav Sabirov.
 * @since 15.07.2018
 * @version 7.
 */
public class User {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * Метод выводит текущую информацию о состоянии памяти.
     */
    public static void info() {
        int mb = 1049600; //1049600
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Used memory: " + (runtime.totalMemory() - runtime.freeMemory()) / mb);
        System.out.println("Free memory: " + runtime.freeMemory() / mb);
        System.out.println("Total memory: " + runtime.totalMemory() / mb);
        System.out.println("Max memory: " + runtime.maxMemory() / mb);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(String.format("Warning! Destroying %s...", this));
        super.finalize();
    }
    public static void main(String[] args) {
        System.out.println("Start program!");
        ArrayList<User> users = new ArrayList<User>();
        info();
        for (int index = 0; index < 300; index++) {
            User currentUser = new User(String.format("Petr %s", index), 28);
            System.out.println(String.format("Create new object %s", currentUser));
            //users.add(new User(String.format("Petr %s", index), 28));
            //System.out.println(String.format("Добавлен объект номер %s", index));
            currentUser = null;
            //System.gc();
        }
        info();
        System.gc();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish program!");
    }
}

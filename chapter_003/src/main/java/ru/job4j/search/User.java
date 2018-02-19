package ru.job4j.search;

/**
 * This is simple class for convert
 * @author Svyatoslav Sabirov.
 * @since 19.02.2018.
 * @version $id$.
 */
public class User {
    //закрытые поля класса
    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}

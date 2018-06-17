package ru.job4j.models;

import javax.persistence.*;

/**
 * This class represents body-model.
 * @author Svyatoslav Sabirov.
 * @since 16.05.2018
 * @version 7.
 */
@Entity
@Table(name = "body")
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    public Body() {
    }

    public Body(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Body{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}

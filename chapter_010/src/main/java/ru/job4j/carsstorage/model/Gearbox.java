package ru.job4j.carsstorage.model;

import javax.persistence.*;

/**
 * This class represents Gearbox-model.
 * @author Svyatoslav Sabirov.
 * @since 15.05.2018
 * @version 7.
 */
@Entity
@Table(name = "gearbox")
public class Gearbox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type")
    private String type;

    public Gearbox() {
    }

    public Gearbox(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Gearbox: %s (%s)", id, type);
    }
}

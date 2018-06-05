package ru.job4j.carsstorage.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * This class represents Transmission-model.
 * @author Svyatoslav Sabirov.
 * @since 15.05.2018
 * @version 7.
 */
@Entity
@Table(name = "transmission")
public class Transmission {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description")
    private String description;

    public Transmission() {
    }

    public Transmission(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Transmission: %s (%s)", id, description);
    }
}

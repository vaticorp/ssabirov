package ru.job4j.carsstorage.model;

import com.sun.istack.internal.NotNull;
import sun.security.pkcs11.wrapper.Constants;

import javax.persistence.*;

/**
 * This class represents Engine-model.
 * @author Svyatoslav Sabirov.
 * @since 15.05.2018
 * @version 7.
 */
@Entity
@Table(name = "engine")
public class Engine {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "capacity")
    private String capacity;

    public Engine() {
    }

    public Engine(long id, String capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return String.format("Engine: %s (%s)", id, capacity);
    }
}

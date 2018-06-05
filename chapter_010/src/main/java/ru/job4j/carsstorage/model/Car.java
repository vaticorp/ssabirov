package ru.job4j.carsstorage.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * This class represents car-models.
 * @author Svyatoslav Sabirov.
 * @since 15.05.2018
 * @version 7.
 */
@Entity
@Table(name = "car")
public class Car {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "model")
    private String model;

    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="engine_id")
    private Engine engine;

    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="transmission_id")
    private Transmission transmission;

    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="gearbox_id")
    private Gearbox gearbox;

    public Car() {
    }

    public Car(long id, String model, Engine engine, Transmission transmission, Gearbox gearbox) {
        this.id = id;
        this.model = model;
        this.engine = engine;
        this.transmission = transmission;
        this.gearbox = gearbox;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }
}

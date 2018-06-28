package ru.job4j.models;

import ru.job4j.hibernate.AdvertisementRunner;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * This class represents advertisement-model.
 * @author Svyatoslav Sabirov.
 * @since 16.05.2018
 * @version 7.
 */
@Entity
@Table(name = "advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;
    @Column(name = "cost")
    private Integer cost;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "soldout")
    private boolean soldOut = false;
    @Column(name = "public")
    private Timestamp publicationDate = AdvertisementRunner.INSTANCE.getStartDay();

    public Advertisement(int id, Car car, int cost, User user, boolean soldOut, Timestamp publicationDate) {
        this.id = id;
        this.car = car;
        this.cost = cost;
        this.user = user;
        this.soldOut = soldOut;
        this.publicationDate = publicationDate;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public Advertisement() {
    }

    public Timestamp getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Timestamp publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean getSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Advertisement{"
                + "id=" + id
                + ", car=" + car
                + ", cost=" + cost
                + ", user=" + user
                + ", soldOut=" + soldOut
                + '}';
    }
}

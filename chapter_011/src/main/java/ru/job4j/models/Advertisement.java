package ru.job4j.models;

import java.sql.Timestamp;

/**
 * This class represents advertisement-model.
 * @author Svyatoslav Sabirov.
 * @since 16.05.2018
 * @version 7.
 */
public class Advertisement {

    private int id;
    private Car car;
    private int cost;
    private User user;
    private boolean soldOut = false;
    private Timestamp publicationDate = new Timestamp(System.currentTimeMillis());

    public Advertisement(int id, Car car, int cost, User user) {
        this.id = id;
        this.car = car;
        this.cost = cost;
        this.user = user;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
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

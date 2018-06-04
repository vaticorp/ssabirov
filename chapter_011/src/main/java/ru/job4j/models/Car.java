package ru.job4j.models;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

/**
 * This class represents car - model.
 * @author Svyatoslav Sabirov.
 * @since 16.05.2018
 * @version 7.
 */
public class Car {

    private int id;
    private Brand brand;
    private Category category;
    private Model model;
    private Body body;
    private int mileage;
    private Timestamp created;
    byte[] imageArray;

    public Car(int id, Brand brand, Category category, Model model, Body body, int mileage, Timestamp date) {
        this.id = id;
        this.brand = brand;
        this.category = category;
        this.model = model;
        this.body = body;
        this.mileage = mileage;
        this.created = date;
        //this.imageArray = imageArray;
    }

    public Car() {
    }

    public byte[] getImageArray() {
        return imageArray;
    }

    public void setImageArray(byte[] imageArray) {
        this.imageArray = imageArray;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Car{"
                + "id=" + id
                + ", brand=" + brand
                + ", category=" + category
                + ", model=" + model
                + ", body=" + body
                + ", mileage=" + mileage
                + ", created=" + created
                + ", imageArray=" + Arrays.toString(imageArray)
                + '}';
    }
}

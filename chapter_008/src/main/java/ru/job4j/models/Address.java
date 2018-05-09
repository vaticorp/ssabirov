package ru.job4j.models;

/**
 * This class represents Address.
 * @author Svyatoslav Sabirov.
 * @since 04.05.2018
 * @version 7.
 */
public class Address {

    private String id;
    private String city;
    private String street;
    private int flat;

    public Address(String id, String city, String street, int flat) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.flat = flat;
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getFlat() {
        return flat;
    }
}

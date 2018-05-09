package ru.job4j.models;

import java.util.List;

/**
 * This class represents User.
 * @author Svyatoslav Sabirov.
 * @since 04.05.2018
 * @version 7.
 */
public class User {

    private String name;
    private int age;
    private Role role;
    private Address residence;
    private List<MusicType> musicInfo;

    public User(String name, int age, Role role, Address residence, List<MusicType> musicInfo) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.residence = residence;
        this.musicInfo = musicInfo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }

    public Address getResidence() {
        return residence;
    }

    public List<MusicType> getMusicInfo() {
        return musicInfo;
    }
}


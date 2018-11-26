package com.model;

import lombok.*;
import java.io.Serializable;

/**
 * This class represents user-model/
 * @author Svyatoslav Sabirov.
 * @since 23.11.2018
 * @version 10.
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -4862926644813433707L;
    private long userId;
    private String name;
    private String surname;
    private int age;
    private Address address;

    public User(long userId, String name, String surname, int age) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}

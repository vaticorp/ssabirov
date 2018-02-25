package ru.job4j.transfers;

import java.util.Objects;

/**
 * This class represents user for bank.
 * @author Svyatoslav Sabirov.
 * @since 25.02.2018
 * @version 7.
 */
public class User {

    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public boolean equals(Object obj) {
        User verifiableUser = (User) obj;
        return super.equals(obj) || (this.name.equals(verifiableUser.name) && this.passport.equals(verifiableUser.passport));
    }
}

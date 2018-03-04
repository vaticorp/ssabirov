package ru.job4j.generic;

/**
 * This class represents RoleStore.
 * @author Svyatoslav Sabirov.
 * @since 04.03.2018
 * @version 7.
 */
public class RoleStore extends AbstractStore<Role> {

    public RoleStore(SimpleArray<Role> innerArray) {
        super(innerArray);
    }
}

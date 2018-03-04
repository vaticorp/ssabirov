package ru.job4j.generic;

/**
 * This class represents UserStore.
 * @author Svyatoslav Sabirov.
 * @since 04.03.2018
 * @version 7.
 */
public class UserStore extends AbstractStore<User>  {

    public UserStore(SimpleArray<User> innerArray) {
        super(innerArray);
    }
}

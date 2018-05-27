package ru.job4j.hibernate;

import ru.job4j.models.Body;
import java.util.List;

/**
 * This class represents class for hibernate-body.
 * @author Svyatoslav Sabirov.
 * @since 20.05.2018
 * @version 7.
 */
public enum BodyRunner implements CommonHibernate<Body> {

    INSTANCE;

    @Override
    public List<Body> getAllEntry() {
        return Context.tx(
                session -> session.createQuery("from Body").getResultList());
    }

    @Override
    public Body getEntryById(int id) {
        return Context.tx(
                session -> session.get(Body.class, id)
        );
    }
}

package ru.job4j.todolist.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.todolist.model.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * This class represents dao for Items
 * @author Svyatoslav Sabirov.
 * @since 14.05.2018
 * @version 15.
 */
public enum ItemContext {

    INSTANCE;

    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public  <T> T tx(final Function<Session, T> command) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }

    public SessionFactory getFactory() {
        return factory;
    }
}

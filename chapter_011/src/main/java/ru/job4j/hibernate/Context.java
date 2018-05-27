package ru.job4j.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.models.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * This class represents class for hibernate.
 * @author Svyatoslav Sabirov.
 * @since 19.05.2018
 * @version 7.
 */
public enum Context {

    INSTANCE;

    private final static SessionFactory FABRIC = new Configuration().configure().buildSessionFactory();

    public static <T> T tx(final Function<Session, T> command) {
        final Session session = FABRIC.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            System.out.println(e.toString());
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }

}

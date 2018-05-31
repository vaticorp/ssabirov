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
public class ItemContext implements HibernateDao {

    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @Override
    public void addEntity(String desc) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Item item = new Item(desc);
            session.save(item);
        } finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public List<Item> getListItemsByStatus(boolean status) {
        return this.tx(
                session -> session.createQuery(!status ? "select i from Item i where i.done = true" : "select i from Item i").getResultList()
        );
    }

    private <T> T tx(final Function<Session, T> command) {
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

    public static void main(String[] args) {
        List<String> as = new ArrayList<>();
        Collections.addAll(as,"2","3","4","5");
        as.forEach((s) -> System.out.println(s));
    }
}

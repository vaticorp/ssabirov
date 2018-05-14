package ru.job4j.todolist.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.todolist.model.Item;

import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;

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
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String queryText = !status ? "select i from Item i where i.done = true" : "select i from Item i";
            final Query query = session.createQuery(queryText);
            return query.getResultList();
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            transaction.commit();
            session.close();
        }
    }
}

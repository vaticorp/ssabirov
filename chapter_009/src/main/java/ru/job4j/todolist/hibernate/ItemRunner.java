package ru.job4j.todolist.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.job4j.todolist.model.Item;

import javax.persistence.Query;
import java.util.List;

/**
 * This class represents Item-hibernate-class
 * @author Svyatoslav Sabirov.
 * @since 02.06.2018
 * @version 10.
 */
public enum ItemRunner implements HibernateDao<Item> {

    INSTANCE;

    @Override
    public void addEntity(Item value) {
        ItemContext.INSTANCE.tx(session -> session.save(value));
    }


    public void updateEntity(long id) {
        ItemContext.INSTANCE.tx(session -> {
                    Query query = session.createQuery("update Item set done =:vdone where id =:vid");
                    query.setParameter("vdone", true);
                    query.setParameter("vid", id);
                    return query.executeUpdate();
                }
        );
    }

    @Override
    public List<Item> getAllEnties() {
        return ItemContext.INSTANCE.tx(
                session -> session.createQuery("from Item").getResultList());
    }

    public List<Item> getListItemsByStatus(boolean status) {
        return ItemContext.INSTANCE.tx(
                session -> session.createQuery(!status ? "select i from Item i where i.done = true" : "select i from Item i").getResultList()
        );
    }

/*    public static void main(String[] args) {

        ItemRunner.INSTANCE.updateEntity(34);
    }*/
}

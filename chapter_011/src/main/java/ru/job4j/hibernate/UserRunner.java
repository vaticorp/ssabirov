package ru.job4j.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.models.Model;
import ru.job4j.models.User;

import javax.persistence.Query;
import java.util.List;

/**
 * This class represents class for hibernate-user.
 * @author Svyatoslav Sabirov.
 * @since 20.05.2018
 * @version 7.
 */
public enum UserRunner implements CommonHibernate<User> {

    INSTANCE;

    public int getUserId(String login, String password) {
        return Context.tx(
                session -> {
                    int id = 0;
                    Query query = session.createQuery("from User i where i.login =:login and i.password =:password");
                    query.setParameter("login", login);
                    query.setParameter("password", password);
                    List<User> list = query.getResultList();
                    if (list.size() > 0) {
                        id = list.get(0).getId();
                    }
                    return id;
                }
        );
    }

    @Override
    public List<User> getAllEntry() {
        return Context.tx(
                session -> session.createQuery("from User").getResultList());
    }

    @Override
    public User getEntryById(int id) {
        return Context.tx(
                session -> session.get(User.class, id)
        );
    }
}

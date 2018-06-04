package ru.job4j.todolist.hibernate;

import ru.job4j.todolist.model.User;
import javax.persistence.Query;
import java.util.List;

/**
 * This class represents User-hibernate-class
 * @author Svyatoslav Sabirov.
 * @since 02.06.2018
 * @version 10.
 */
public enum UserRunner implements  HibernateDao<User> {

    INSTANCE;

    @Override
    public void addEntity(User value) {
        ItemContext.INSTANCE.tx(session -> session.save(value));
    }

    @Override
    public List<User> getAllEnties() {
        return ItemContext.INSTANCE.tx(
                session -> session.createQuery("from User").getResultList());
    }

    public boolean userExist(String login, String password) {
        return ItemContext.INSTANCE.tx(
                session -> {
                    Query query = session.createQuery("from User i where i.login =:login and i.password =:password");
                    query.setParameter("login", login);
                    query.setParameter("password", password);
                    return query.getResultList().size() > 0;
                }
        );
    }
}

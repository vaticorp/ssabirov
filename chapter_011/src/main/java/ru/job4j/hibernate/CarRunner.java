package ru.job4j.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.models.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * This class represents class for hibernate-car.
 * @author Svyatoslav Sabirov.
 * @since 20.05.2018
 * @version 7.
 */
public enum CarRunner implements CommonHibernate<Car> {

    INSTANCE;

    public void addCar(Car newCar) {
        Context.tx(session -> session.save(newCar));
    }

    @Override
    public List<Car> getAllEntry() {
        return Context.tx(
                session -> session.createQuery("from Car").getResultList());
    }

    @Override
    public Car getEntryById(int id) {
        return Context.tx(
                session -> session.get(Car.class, id)
        );
    }
}

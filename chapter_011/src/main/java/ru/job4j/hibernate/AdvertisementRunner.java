package ru.job4j.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.models.Advertisement;
import ru.job4j.models.Car;

import java.util.List;
import java.util.Objects;

/**
 * This class represents hibernate-Advertisement.
 * @author Svyatoslav Sabirov.
 * @since 16.05.2018
 * @version 7.
 */
public enum AdvertisementRunner implements CommonHibernate<Advertisement> {

    INSTANCE;

    @Override
    public List<Advertisement> getAllEntry() {
        return Context.tx(
                session -> session.createQuery("from Advertisement").getResultList());
    }

    @Override
    public Advertisement getEntryById(int id) {
        return Context.tx(
                session -> session.get(Advertisement.class, id)
        );
    }

    public void addAdvertisement(Advertisement advertisement) {
        Context.tx(session -> session.save(advertisement));
    }

    public void updateAdvertisement(Advertisement advertisement) {
        Context.tx(session -> session.merge(advertisement));
    }

    public static void main(String[] args) {
        Advertisement advertisement = AdvertisementRunner.INSTANCE.getEntryById(4);
        advertisement.setSoldOut(true);
        AdvertisementRunner.INSTANCE.updateAdvertisement(advertisement);
    }
}

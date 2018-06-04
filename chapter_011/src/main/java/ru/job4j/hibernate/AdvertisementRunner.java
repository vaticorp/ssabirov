package ru.job4j.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.LocalDateTime;
import ru.job4j.models.Advertisement;
import ru.job4j.models.Car;

import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * This class represents hibernate-Advertisement.
 * @author Svyatoslav Sabirov.
 * @since 16.05.2018
 * @version 7.
 */
public enum AdvertisementRunner implements CommonHibernate<Advertisement> {

    INSTANCE;

    @Override
    public void addEntry(Advertisement newAdvertisement) {
        Context.INSTANCE.tx(session -> session.save(newAdvertisement));
    }

    @Override
    public List<Advertisement> getAllEntry() {
        return Context.INSTANCE.tx(
                session -> session.createQuery("from Advertisement").getResultList());
    }

    @Override
    public Advertisement getEntryById(int id) {
        return Context.INSTANCE.tx(
                session -> session.get(Advertisement.class, id)
        );
    }

    public void addAdvertisement(Advertisement advertisement) {
        Context.INSTANCE.tx(session -> session.save(advertisement));
    }

    public void updateAdvertisement(Advertisement advertisement) {
        Context.INSTANCE.tx(session -> session.merge(advertisement));
    }

    public List<Advertisement> getAdvertisementByActualDay() {
        return Context.INSTANCE.tx(
                session -> {
                    Timestamp currentDay = new Timestamp(System.currentTimeMillis());
                    LocalDateTime endOfDay = currentDay.toLocalDateTime().with(LocalTime.MAX);
                    LocalDateTime startOfDay = currentDay.toLocalDateTime().with(LocalTime.MIN);
                    Query query = session.createQuery("from Advertisement adv where adv.publicationDate >:start and adv.publicationDate <:end");
                    query.setParameter("start", Timestamp.valueOf(startOfDay));
                    query.setParameter("end", Timestamp.valueOf(endOfDay));
                    return query.getResultList();
                }
        );
    }

    public List<Advertisement> getAdvertisementByImage() {
        return Context.INSTANCE.tx(
                session -> {
                    Timestamp currentDay = new Timestamp(System.currentTimeMillis());
                    LocalDateTime endOfDay = currentDay.toLocalDateTime().with(LocalTime.MAX);
                    LocalDateTime startOfDay = currentDay.toLocalDateTime().with(LocalTime.MIN);
                    Query query = session.createQuery("from Advertisement adv where bit_length(adv.car.imageArray) > 0");
                    //query.setParameter("mil",Null);
                    return query.getResultList();
                }
        );
    }

    public List<Advertisement> getAdvertisementByBrandId(String id) {
        return Context.INSTANCE.tx(
                session -> {
                    Timestamp currentDay = new Timestamp(System.currentTimeMillis());
                    LocalDateTime endOfDay = currentDay.toLocalDateTime().with(LocalTime.MAX);
                    LocalDateTime startOfDay = currentDay.toLocalDateTime().with(LocalTime.MIN);
                    Query query = session.createQuery("from Advertisement adv where adv.car.brand.id =:id");
                    query.setParameter("id", Integer.parseInt(id));
                    return query.getResultList();
                }
        );
    }
}

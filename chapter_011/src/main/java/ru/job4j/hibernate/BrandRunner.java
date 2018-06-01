package ru.job4j.hibernate;

import ru.job4j.models.Brand;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * This class represents class for hibernate-brand.
 * @author Svyatoslav Sabirov.
 * @since 20.05.2018
 * @version 7.
 */
public enum BrandRunner implements CommonHibernate<Brand> {

    INSTANCE;

    @Override
    public void addEntry(Brand newBrand) {
        Context.tx(session -> session.save(newBrand));
    }

    @Override
    public List<Brand> getAllEntry() {
        return Context.tx(
                session -> session.createQuery("from Brand").getResultList());
    }

    @Override
    public Brand getEntryById(final int id) {
        return Context.tx(
                session -> session.get(Brand.class, id)
        );
    }
}

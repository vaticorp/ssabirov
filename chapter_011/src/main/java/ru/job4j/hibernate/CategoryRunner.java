package ru.job4j.hibernate;

import ru.job4j.models.Category;

import java.util.List;

/**
 * This class represents class for hibernate-category.
 * @author Svyatoslav Sabirov.
 * @since 20.05.2018
 * @version 7.
 */
public enum CategoryRunner implements CommonHibernate<Category> {

    INSTANCE;

    @Override
    public List<Category> getAllEntry() {
        return Context.tx(
                session -> session.createQuery("from Category").getResultList());
    }

    @Override
    public Category getEntryById(int id) {
        return Context.tx(
                session -> session.get(Category.class, id)
        );
    }
}

package ru.job4j.hibernate;
import ru.job4j.models.Model;

import javax.persistence.Query;
import java.util.List;

/**
 * This class represents class for hibernate-model.
 * @author Svyatoslav Sabirov.
 * @since 20.05.2018
 * @version 7.
 */
public enum  ModelRunner implements CommonHibernate<Model> {

    INSTANCE;

    @Override
    public void addEntry(Model newModel) {
        Context.INSTANCE.tx(session -> session.save(newModel));
    }

    @Override
    public List<Model> getAllEntry() {
        return Context.INSTANCE.tx(
                session -> session.createQuery("from Model").getResultList());
    }

    @Override
    public Model getEntryById(int id) {
        return Context.INSTANCE.tx(
                session -> session.get(Model.class, id)
        );
    }
}

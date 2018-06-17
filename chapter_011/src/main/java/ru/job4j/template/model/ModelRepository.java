package ru.job4j.template.model;

import ru.job4j.models.Model;
import java.util.List;

/**
 * This class represents repository for model.
 * @author Svyatoslav Sabirov.
 * @since 16.06.2018
 * @version 7.
 */
public interface ModelRepository {
    List<Model> getAll();
    Model getModelByID(int id);
}

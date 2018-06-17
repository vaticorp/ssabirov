package ru.job4j.template.model;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.Model;

/**
 * This class represents model-crud.
 * @author Svyatoslav Sabirov.
 * @since 16.06.2018
 * @version 9.
 */
public interface ModelCrud  extends CrudRepository<Model, Integer> {

}

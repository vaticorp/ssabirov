package ru.job4j.template.body;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.Body;

/**
 * This class represents BodyCrud.
 * @author Svyatoslav Sabirov.
 * @since 15.06.2018
 * @version 10.
 */
public interface BodyCrud extends CrudRepository<Body, Integer> {

}

package ru.job4j.template.body;

import ru.job4j.models.Body;
import java.util.List;

/**
 * This class represents body-repository.
 * @author Svyatoslav Sabirov.
 * @since 15.06.2018
 * @version 10.
 */
public interface BodyRepository {
    List<Body> getAll();
    Body getUserByID(int id);
}

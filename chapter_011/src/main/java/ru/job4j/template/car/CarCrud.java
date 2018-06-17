package ru.job4j.template.car;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.Car;

/**
 * This class represents interface for car.
 * @author Svyatoslav Sabirov.
 * @since 16.06.2018
 * @version 10.
 */
public interface CarCrud extends CrudRepository<Car, Integer> {
}

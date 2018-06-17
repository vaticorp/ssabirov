package ru.job4j.template.car;

import ru.job4j.models.Car;
import java.util.List;

/**
 * This class represents repository for car.
 * @author Svyatoslav Sabirov.
 * @since 16.06.2018
 * @version 10.
 */
public interface CarRepository {
    List<Car> getAll();
    Car getCarByID(int id);
    Car addCar(Car car);
}

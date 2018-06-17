package ru.job4j.template.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.models.Car;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents service for car.
 * @author Svyatoslav Sabirov.
 * @since 16.06.2018
 * @version 7.
 */
@Service
@Transactional
public class CarService implements CarRepository {
    @Autowired
    private CarCrud carCrud;
    @Override
    public List<Car> getAll() {
        List<Car> list = new ArrayList<Car>();
        carCrud.findAll().forEach(current -> list.add(current));
        return list;
    }
    @Override
    public Car getCarByID(int id) {
        return carCrud.findById(id).get();
    }
    @Override
    public Car addCar(Car car) {
        return carCrud.save(car);
    }
}

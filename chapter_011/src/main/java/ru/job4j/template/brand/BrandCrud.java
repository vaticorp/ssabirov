package ru.job4j.template.brand;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.Brand;

/**
 * This class represents BrandCrud.
 * @author Svyatoslav Sabirov.
 * @since 15.06.2018
 * @version 10.
 */
public interface BrandCrud extends CrudRepository<Brand, Integer> {
}

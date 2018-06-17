package ru.job4j.template.brand;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.Brand;
import java.util.List;

/**
 * This class represents repository for brand.
 * @author Svyatoslav Sabirov.
 * @since 14.06.2018
 * @version 11.
 */
public interface BrandRepository {
    List<Brand> getAll();
    Brand getBrandByID(int id);
}

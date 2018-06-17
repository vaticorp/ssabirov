package ru.job4j.template.category;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.models.Category;

/**
 * This class represents CategoryCrud.
 * @author Svyatoslav Sabirov.
 * @since 15.06.2018
 * @version 10.
 */
public interface CategoryCrud extends CrudRepository<Category, Integer> {
}

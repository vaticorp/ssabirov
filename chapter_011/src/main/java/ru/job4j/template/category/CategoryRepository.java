package ru.job4j.template.category;

import ru.job4j.models.Category;
import java.util.List;

/**
 * This class represents repository-interface.
 * @author Svyatoslav Sabirov.
 * @since 15.06.2018
 * @version 7.
 */
public interface CategoryRepository {
    List<Category> getAll();
    Category getCategoryByID(int id);
}

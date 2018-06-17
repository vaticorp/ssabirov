package ru.job4j.template.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.models.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents class for Category.
 * @author Svyatoslav Sabirov.
 * @since 15.06.2018
 * @version 7.
 */
@Service
@Transactional
public class CategoryService implements CategoryRepository {
    @Autowired
    private CategoryCrud categoryCrud;
    @Override
    public List<Category> getAll() {
        List<Category> list = new ArrayList<Category>();
        categoryCrud.findAll().forEach(current -> list.add(current));
        return list;
    }
    @Override
    public Category getCategoryByID(int id) {
        return categoryCrud.findById(id).get();
    }
}

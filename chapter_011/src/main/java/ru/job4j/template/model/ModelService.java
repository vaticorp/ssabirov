package ru.job4j.template.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.models.Body;
import ru.job4j.models.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents service for model.
 * @author Svyatoslav Sabirov.
 * @since 16.06.2018
 * @version 7.
 */
@Service
@Transactional
public class ModelService implements ModelRepository {
    @Autowired
    private ModelCrud modelCrud;
    @Override
    public List<Model> getAll() {
        List<Model> list = new ArrayList<Model>();
        modelCrud.findAll().forEach(current -> list.add(current));
        return list;
    }
    @Override
    public Model getModelByID(int id) {
        return modelCrud.findById(id).get();
    }
}

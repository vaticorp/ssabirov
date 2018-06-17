package ru.job4j.template.body;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.models.Body;
import ru.job4j.models.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents service for body.
 * @author Svyatoslav Sabirov.
 * @since 15.06.2018
 * @version 7.
 */
@Service
@Transactional
public class BodyService implements BodyRepository {

    @Autowired
    private BodyCrud bodyCrud;

    @Override
    public List<Body> getAll() {
        List<Body> list = new ArrayList<Body>();
        bodyCrud.findAll().forEach(current -> list.add(current));
        return list;
    }

    @Override
    public Body getUserByID(int id) {
        return bodyCrud.findById(id).get();
    }
}

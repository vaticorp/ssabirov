package ru.job4j.template.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.job4j.models.Brand;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents
 * @author Svyatoslav Sabirov.
 * @since 14.06.2018
 * @version 7.
 */
@Service
@Transactional
public class BrandService implements BrandRepository {

    @Autowired
    private BrandCrud brandCrud;

    @Override
    public List<Brand> getAll() {
        List<Brand> list = new ArrayList<Brand>();
        brandCrud.findAll().forEach(current -> list.add(current));
        return list;
    }
    @Override
    public Brand getBrandByID(int id) {
        return brandCrud.findById(id).get();
    }
}

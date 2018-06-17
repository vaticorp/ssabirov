package ru.job4j.template.advertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.models.Advertisement;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents service for Advertisement.
 * @author Svyatoslav Sabirov.
 * @since 16.06.2018
 * @version 10.
 */
@Service
@Transactional
public class AdvertisementService implements AdvertisementRepository {

    @Autowired
    AdvertisementCrud advertisementCrud;

    @Override
    public List<Advertisement> getAll() {
        List<Advertisement> list = new ArrayList<Advertisement>();
        advertisementCrud.findAll().forEach(current -> list.add(current));
        return list;
    }

    @Override
    public Advertisement getAdvertisementByID(int id) {
        return advertisementCrud.findById(id).get();
    }

    @Override
    public Advertisement addAdvertisement(Advertisement car) {
        return advertisementCrud.save(car);
    }

    public List<Advertisement> findBySold(Boolean flag) {
        return advertisementCrud.findBySold(flag);
    }

    public List<Advertisement> findByImage() {
        return advertisementCrud.findByImage();
    }

    public List<Advertisement> findByBrand(int id) {
        return advertisementCrud.findByBrand(id);
    }

    public List<Advertisement> findByPublication(Timestamp timestamp) {
        return advertisementCrud.findByPublication(timestamp);
    }
}

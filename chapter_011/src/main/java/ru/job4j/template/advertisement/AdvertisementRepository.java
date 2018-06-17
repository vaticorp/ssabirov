package ru.job4j.template.advertisement;

import ru.job4j.models.Advertisement;
import java.util.List;

/**
 * This class represents repository for Advertisement.
 * @author Svyatoslav Sabirov.
 * @since 16.06.2018
 * @version 7.
 */
public interface AdvertisementRepository {
    List<Advertisement> getAll();
    Advertisement getAdvertisementByID(int id);
    Advertisement addAdvertisement(Advertisement car);
}

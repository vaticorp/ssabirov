package ru.job4j.template.advertisement;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.models.Advertisement;

import java.sql.Timestamp;
import java.util.List;

/**
 * This class represents crud for Advertisement.
 * @author Svyatoslav Sabirov.
 * @since 16.06.2018
 * @version 10.
 */
public interface AdvertisementCrud extends CrudRepository<Advertisement, Integer> {

    @Query("select b from Advertisement b where b.soldOut = :soldOut")
    List<Advertisement> findBySold(@Param("soldOut") Boolean soldOut);

    @Query("select adv from Advertisement adv where bit_length(adv.car.imageArray) > 0")
    List<Advertisement> findByImage();

    @Query("select adv from Advertisement adv where adv.car.brand.id =:id")
    List<Advertisement> findByBrand(@Param("id") int id);

    @Query("select adv from Advertisement adv where adv.publicationDate =:start")
    List<Advertisement> findByPublication(@Param("start") Timestamp timestamp);
}



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.models.Advertisement;
import ru.job4j.models.Brand;
import ru.job4j.template.advertisement.AdvertisementService;
import ru.job4j.template.brand.BrandService;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class represents BrandService-test
 * @author Svyatoslav Sabirov.
 * @since 01.06.2018
 * @version 9.
 */
public class BrandServiceTest {
    @Test
    public void whenGetAllBrands() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        /*BrandService rep = applicationContext.getBean(BrandService.class);
        Brand brand = rep.getBrandByID(1);
        System.out.println(brand);*/
        AdvertisementService rep = applicationContext.getBean(AdvertisementService.class);
        List<Advertisement> list = rep.findByBrand(1);
        list.forEach(s -> System.out.println(s));
        //brands.forEach(s -> System.out.println(s));
        //Iterable<Brand> list = new BrandService().brandCrud.findAll();
/*        List<Brand> list = new BrandService().getAll();
        list.forEach(s -> System.out.println(s));*/
    }
}
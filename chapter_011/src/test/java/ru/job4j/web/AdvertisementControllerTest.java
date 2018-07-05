package ru.job4j.web;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import ru.job4j.models.*;
import ru.job4j.template.advertisement.AdvertisementService;
import ru.job4j.template.body.BodyService;
import ru.job4j.template.brand.BrandService;
import ru.job4j.template.car.CarService;
import ru.job4j.template.category.CategoryService;
import ru.job4j.template.model.ModelService;
import ru.job4j.template.user.UserService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * This class represents test-class
 * @author Svyatoslav Sabirov.
 * @since 04.07.2018
 * @version 7.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AdvertisementController.class)
public class AdvertisementControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AdvertisementService advertisementService;
    @MockBean
    CategoryService categoryService;
    @MockBean
    BodyService bodyService;
    @MockBean
    ModelService modelService;
    @MockBean
    UserService userService;
    @MockBean
    CarService carService;
    @MockBean
    BrandService brandService;

    @Test
    @WithMockUser(username = "vaticorp", roles = {"ADMIN"})
    public void whenWeSaveNewAdvertisement() throws Exception{
        Body body = new Body(1,"test");
        Category category = new Category(1,"test");
        Model model = new Model(1, "test");
        Brand brand = new Brand("Test","Test");
        Car car = new Car(1, brand, category, model, body, 12, new Date());
        Advertisement advertisement = new Advertisement(1, car, 3, new User(), false, new Timestamp(System.currentTimeMillis()));
        this.mvc.perform(
                post("/create").flashAttr("advertisement", advertisement).with(csrf())
        ).andExpect(
                status().is3xxRedirection()
        );
        verify(this.advertisementService, times(1)).addAdvertisement(advertisement);
    }

    @Test
    @WithMockUser(username = "vaticorp", roles = {"ADMIN"})
    public void whenWeGetFail() throws Exception {
        this.mvc.perform(
                get("/fail").accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("fail")
        );
    }

    @Test
    @WithMockUser(username = "vaticorp", roles = {"ADMIN"})
    public void whenWeEditAdvertisement() throws Exception {
        Body body = new Body(1,"test");
        Category category = new Category(1,"test");
        Model model = new Model(1, "test");
        Brand brand = new Brand("Test","Test");
        Car car = new Car(1, brand, category, model, body, 12, new Date());
        given(
                this.advertisementService.getAdvertisementByID(66)
        ).willReturn(new Advertisement(1, car, 3, new User(), false, new Timestamp(System.currentTimeMillis())));
        this.mvc.perform(
                get("/edit").accept(MediaType.TEXT_HTML).param("id","66")
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("edit")
        );
    }

    @Test
    @WithMockUser(username = "vaticorp", roles = {"ADMIN"})
    public void whenWeRedirectToMainPages() throws Exception{
        given(
                this.brandService.getAll()
        ).willReturn(new ArrayList<Brand>(Lists.newArrayList(new Brand("LEXUS", "LEXUS"))
                )
        );
        this.mvc.perform(
                get("/list").accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("main")
        );
    }
}

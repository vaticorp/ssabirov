package com.controler;

import com.model.Address;
import com.model.User;
import com.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import org.assertj.core.util.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
public class CatalogControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserService userService;

    @Test
    public void whenWeDoFirstEnterThenOpenMainPage() throws Exception {
        this.mvc.perform(
                get("/enter").accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("start")
        );
    }

    @Test
    public void whenWeGetAllUsersThenReturn() throws Exception {
        User user = new User();
        user.setAge(18);
        user.setName("Vasy");
        user.setSurname("Pupkin");
        given(
                this.userService.getAllUsers()
        ).willReturn(new ArrayList<User>(Lists.newArrayList(user)
                )
        );
        this.mvc.perform(
                get("/list").accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("start")
        );
    }

    @Test
    public void whenWeAddNewUserThenCheck() throws Exception {
        Address address = new Address();
        address.setStreet("Tverskaya");
        address.setIndex(12345);
        address.setHouseNumber(23);
        address.setCity("Omsk");
        User user = new User();
        user.setAddress(address);
        user.setAge(18);
        user.setName("Vasy");
        user.setSurname("Pupkin");
        this.mvc.perform(
                post("/add").flashAttr("user", user).with(csrf())
        ).andExpect(
                view().name("start")
        );
        verify(this.userService, times(1)).addUser(user);
    }
}
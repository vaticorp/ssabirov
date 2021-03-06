package ru.job4j.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * This class represents Mvc-configuration.
 * @author Svyatoslav Sabirov.
 * @since 20.06.2018
 * @version 7.
 */

@EnableTransactionManagement
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("list").setViewName("list");
        registry.addViewController("create").setViewName("create");
        registry.addViewController("edit").setViewName("edit");
        registry.addViewController("auto").setViewName("auto");
        registry.addViewController("fail").setViewName("fail");
        registry.addViewController("json").setViewName("json");
        registry.addViewController("filt").setViewName("filt");
        registry.addViewController("login").setViewName("Auto");
        /*registry.addViewController("main").setViewName("main");*/
        /*registry.addViewController("j_spring_security_check").setViewName("j_spring_security_check");
        registry.addViewController("json").setViewName("json");
        registry.addViewController("image").setViewName("image");*/
    }
}

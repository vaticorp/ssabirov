package fullstack.web;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class represents configuration-class.
 * @author Svyatoslav Sabirov.
 * @since 11.09.2018
 * @version 9.
 */
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("start");
    }
}

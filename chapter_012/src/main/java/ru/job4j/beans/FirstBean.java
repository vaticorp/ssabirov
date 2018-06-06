package ru.job4j.beans;

import org.springframework.stereotype.Component;

/**
 * This class represents first Bean
 * @author Svyatoslav Sabirov.
 * @since 06.06.2018
 * @version 7.
 */
@Component
public class FirstBean {

    private String name = "first";

    public FirstBean() {
    }

    public FirstBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FirstBean{"
                + "name='" + name + '\''
                + '}';
    }
}

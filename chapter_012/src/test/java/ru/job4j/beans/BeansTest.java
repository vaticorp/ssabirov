package ru.job4j.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class represents
 * @author Svyatoslav Sabirov.
 * @since 06.06.2018
 * @version 7.
 */
public class BeansTest {

    @Test
    public void whenWeShouldLoadFirstBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        FirstBean firstBean = context.getBean(FirstBean.class);
        System.out.println(firstBean);
    }

    @Test
    public void whenWeShouldLoadSecondBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        SecondBean secondBean = context.getBean(SecondBean.class);
        System.out.println(secondBean);
    }

}

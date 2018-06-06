package ru.job4j.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class represents importUser-storage;
 * @author Svyatoslav Sabirov.
 * @since 06.06.2018
 * @version 7.
 */
public class ImportUserTest {

    @Test
    public void whenWeShouldAddUserWithMemoryStorage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage memoryStorage = context.getBean(MemoryStorage.class);
        memoryStorage.add(new User(1, "Slava"));
        assertThat(1, is(memoryStorage.getList().size()));
    }

    @Test
    public void whenWeShouldAddTwoUsersWithMemoryStorage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage memoryStorage = context.getBean(MemoryStorage.class);
        memoryStorage.add(new User(1, "Slava"));
        memoryStorage.add(new User(2, "Petr"));
        //memoryStorage.getList().forEach(s -> System.out.println(s));
        assertThat(2, is(memoryStorage.getList().size()));
    }
}
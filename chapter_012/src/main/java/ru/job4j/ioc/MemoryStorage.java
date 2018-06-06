package ru.job4j.ioc;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * This class represents memory-storage.
 * @author Svyatoslav Sabirov.
 * @since 06.06.2018
 * @version 7.
 */
@Primary
@Component
public class MemoryStorage implements Storage {

    private ArrayList<User> list = new ArrayList<User>();

    @Override
    public void add(User user) {
        list.add(user);
    }

    public ArrayList<User> getList() {
        return list;
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
    }

    public void printUsers() {
        list.forEach(user -> System.out.println(user));
    }
}

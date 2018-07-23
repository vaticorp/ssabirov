package ru.job4j.search;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This is simple class for PhoneDictionary.
 * @author Svyatoslav Sabirov.
 * @version $id$.
 * @since 27.02.2018
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = persons.stream().filter(people -> people.getAddress().contains(key) || people.getName().contains(key) || people.getSurname().contains(key) || people.getPhone().contains(key)).collect(Collectors.toList());
        return result;
    }
}

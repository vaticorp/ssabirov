package ru.job4j.search;

import java.util.*;

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
        List<Person> result = new ArrayList<>();
        for (Person people : persons) {
            if (people.getAddress().contains(key) || people.getName().contains(key) || people.getSurname().contains(key) || people.getPhone().contains(key)) {
                result.add(people);
            }
        }
        return result;
    }
}

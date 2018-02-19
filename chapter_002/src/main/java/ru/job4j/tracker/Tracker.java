package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is using for storage items.
 * @author Svytoslav Sabirov.
 * @since 27.02.2018
 */
public class Tracker {

    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<Item>();

    /**
     * Указатель ячейки для новой заявки.
     */
    //private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Method for edit item.
     * @param id - identifier.
     * @param item - bid.
     */
    public void replace(String id, Item item) {
        for (Item current : items) {
            if (current.getId().equals(id)) {
                item.setId(current.getId());
                this.items.add(items.indexOf(current), item);
                break;
            }
        }
    }
    /**
     * Delete by bid-id.
     * @param id - identifier.
     */
    public void delete(String id) {
        for (Item current : items) {
            if (current.getId().equals(id)) {
                items.remove(current);
                break;
            }
        }
    }

    /**
     * Get list of bid.
     * @return - list of bid.
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Get list by name;
     * @param key - bid-name;
     * @return bid-list.
     */
    public List<Item> findByName(String key) {
        List<Item> currientitems = new ArrayList<Item>();
        for (Item item: items) {
            if (item.getName().equals(key)) {
                currientitems.add(item);
            }
        }
        return currientitems;
    }

    /**
     * Get bid by id.
     * @param id
     * @return bid.
     */
    public Item findById(String id) {
        Item found = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                found = item;
                break;
            }
        }
        return found;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + (int) (Math.random() * 3));
    }
}

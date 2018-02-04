package ru.job4j.tracker;

/**
 * This class is using for storage items.
 * @author Svytoslav Sabirov.
 * @since 27.02.2018
 */
public class Tracker {

    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Method for edit item.
     * @param id - identifier.
     * @param item - bid.
     */
    public void replace(String id, Item item) {
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                items[index] = item;
                break;
            }
        }
    }

    /**
     * Delete by bid-id.
     * @param id - identifier.
     */
    public void delete(String id) {
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                items[index] = null;
                //Item[] updatedarray = new Item[items.length - 1];
                //В одной строке не очень хорошо читается
                System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                break;
            }
        }
    }

    /**
     * Get list of bid.
     * @return - list of bid.
     */
    public Item[] findAll() {
        Item[] currientitems = new Item[this.position];
        for (int index = 0; index < this.position; index++) {
            currientitems[index] = this.items[index];
        }
        return currientitems;
    }

    /**
     * Get list by name;
     * @param key - bid-name;
     * @return bid-list.
     */
    public Item[] findByName(String key) {
        Item[] currientitems = new Item[this.position];
        int overlap = 0;
        for (Item item:items) {
            if (item != null && item.getName().equals(key)) {
                currientitems[overlap++] = item;
            }
        }
        System.arraycopy(currientitems, 0, currientitems, 0, overlap);
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
            if (item != null && item.getId().equals(id)) {
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

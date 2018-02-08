package ru.job4j.tracker;

/**
 * This my enter-class.
 * @author Svyatoslav Sabirov.
 * @since 03.02.2018
 * @version 01.
 */
public class StartUI {

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    private int[] range;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {

       int exitvalue = new ExitProgram().key();
       MenuTracker menu = new MenuTracker(this.input, this.tracker);
       menu.createMenu();
       range = menu.createRangeOfValues();
       boolean exit = false;
        while (!exit) {
            menu.showMenu();
            int answer = this.input.ask("Введите пункт меню : ", range);
            menu.select(answer);
            if (exitvalue == answer) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой языки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Output all items.
     */
    private void showItems() {
        System.out.println("------------ Актуальный список заявок --------------");
        Item[] currentitems = this.tracker.findAll();
        for (Item item:currentitems) {
            if (item != null) {
                System.out.println(item.toString());
            }
        }
        System.out.println("------------ Конец списка --------------");
    }

    /**
     * Edit item.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите идентификатор заявки для замены :");
        String name = this.input.ask("Введите имя новой заявки :");
        String desc = this.input.ask("Введите описание новой заявки :");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
        System.out.println("------------ Конец редактирования --------------");
    }

    /**
     * Delete item.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите идентификатор заявки :");
        this.tracker.delete(id);
        System.out.println("------------ Конец удаления заявки --------------");
    }

    /**
     * Find item by name.
     */
    private Item findItemByName() {
        Item currentItem = null;
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] items = this.tracker.findByName(name);
        if (items.length != 0) {
            for (Item current:items) {
                if (current != null) {
                    currentItem = current;
                    System.out.println("Заявка найдена: " + currentItem.toString());
                }
            }
        } else {
            System.out.println("Заявка не найдена!");
        }
        System.out.println("------------ Конец поиска по имени --------------");
        return currentItem;
    }

    /**
     * Find item by id.
     */
    private Item findItemById() {
        Item currentItem = null;
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите идентификатор заявки :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            currentItem = item;
            System.out.println("Заявка найдена: " + currentItem.toString());
        } else {
            System.out.println("Заявка не найдена!");
        }
        System.out.println("------------ Конец поиска по id --------------");

        return currentItem;
    }

    /**
     * Show menu.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
    }

    /**
     * Запуск программы.
     * @param args - default parameter.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}

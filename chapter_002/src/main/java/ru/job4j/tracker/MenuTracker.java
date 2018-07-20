package ru.job4j.tracker;

import java.util.List;

/**
 * Interface for menu.
 * @author Svyatoslav Sabirov.
 * @since 07.02.2018.
 * @version $id$.
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void createMenu() {
        actions[0] = new AddNewItems(0, "Add new Item");
        actions[1] = new ShowAllItems(1, "Show all items");
        actions[2] = new MenuTracker.EditItem(2, "Edit item");
        actions[3] = new DeleteItems(3, "Delete item");
        actions[4] = new FindItemById(4, "Find item by Id");
        actions[5] = new FindItemByName(5, "Find item by name");
        actions[6] = new ExitProgram(6, "Exit Program");
    }

    public int[] createRangeOfValues() {
        int[] range = new int[actions.length];
        for (int i = 0; i < actions.length; i++) {
            range[i] = actions[i].key();
        }
        return range;
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void showMenu() {
        for (UserAction action: actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddNewItems extends BaseAction {

        public AddNewItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой языки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    private static class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите идентификатор заявки для замены :");
            String name = input.ask("Введите имя новой заявки :");
            String desc = input.ask("Введите описание новой заявки :");
            Item item = new Item(name, desc);
            tracker.replace(id, item);
            System.out.println("------------ Конец редактирования --------------");
        }
    }
}

class ShowAllItems extends BaseAction {

    public ShowAllItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Актуальный список заявок --------------");
        List<Item> currentitems = tracker.findAll();
        for (Item item:currentitems) {
            if (item != null) {
                System.out.println(item.toString());
            }
        }
        System.out.println("------------ Конец списка --------------");
    }
}

class DeleteItems extends BaseAction {

    public DeleteItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удаление заявки --------------");
        String id = input.ask("Введите идентификатор заявки :");
        tracker.delete(id);
        System.out.println("------------ Конец удаления заявки --------------");
    }
}

class FindItemById extends BaseAction {

    public FindItemById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item currentItem = null;
        System.out.println("------------ Поиск заявки по id --------------");
        String id = input.ask("Введите идентификатор заявки :");
        //System.out.println(id);
        Item item = tracker.findById(id);
        if (item != null) {
            currentItem = item;
            System.out.println("Заявка найдена: " + currentItem.toString());
        } else {
            System.out.println("Заявка не найдена!");
        }
        System.out.println("------------ Конец поиска по id --------------");
    }
}

class FindItemByName extends BaseAction {

    public FindItemByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item currentItem = null;
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = input.ask("Введите имя заявки :");
        List<Item> items = tracker.findByName(name);
        if (items.size() != 0) {
            for (Item current:items) {
                if (current != null) {
                    System.out.println("Заявка найдена: " + current.toString());
                }
            }
        } else {
            System.out.println("Заявка не найдена!");
        }
        System.out.println("------------ Конец поиска по имени --------------");
    }
}

class  ExitProgram extends BaseAction {

    public ExitProgram(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Exit........");
    }
}




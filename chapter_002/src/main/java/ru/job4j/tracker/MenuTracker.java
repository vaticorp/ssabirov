package ru.job4j.tracker;

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
        actions[0] = new AddNewItems();
        actions[1] = new ShowAllItems();
        actions[2] = new MenuTracker.EditItem();
        actions[3] = new DeleteItems();
        actions[4] = new FindItemById();
        actions[5] = new FindItemByName();
        actions[6] = new ExitProgram();
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

    private class AddNewItems implements UserAction {

        @Override
        public int key() {
            return 0;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item");
        }
    }

    private static class EditItem implements UserAction {

        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }
}

class ShowAllItems implements UserAction {

    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Актуальный список заявок --------------");
        Item[] currentitems = tracker.findAll();
        for (Item item:currentitems) {
            if (item != null) {
                System.out.println(item.toString());
            }
        }
        System.out.println("------------ Конец списка --------------");
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Show all items");
    }

}

class DeleteItems implements UserAction {

    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удаление заявки --------------");
        String id = input.ask("Введите идентификатор заявки :");
        tracker.delete(id);
        System.out.println("------------ Конец удаления заявки --------------");
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Delete item");
    }

}

class FindItemById implements UserAction {

    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item currentItem = null;
        System.out.println("------------ Поиск заявки по id --------------");
        String id = input.ask("Введите идентификатор заявки :");
        Item item = tracker.findById(id);
        if (item != null) {
            currentItem = item;
            System.out.println("Заявка найдена: " + currentItem.toString());
        } else {
            System.out.println("Заявка не найдена!");
        }
        System.out.println("------------ Конец поиска по id --------------");
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Find item by Id");
    }

}

class FindItemByName implements UserAction {

    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item currentItem = null;
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = input.ask("Введите имя заявки :");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item current:items) {
                if (current != null) {
                    //currentItem = current;
                    System.out.println("Заявка найдена: " + currentItem.toString());
                }
            }
        } else {
            System.out.println("Заявка не найдена!");
        }
        System.out.println("------------ Конец поиска по имени --------------");
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Find item by Id");
    }

}

class  ExitProgram implements UserAction {

    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Exit........");
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Exit Program");
    }

}




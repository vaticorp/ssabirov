package ru.job4j.tracker;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * This is test class for StartUI.
 * @author Svyatoslav Sabirov.
 * @since 05.02.2018
 * @version $id$.
 */
public class StartUITest {


    private final PrintStream stout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Первая заявка", "Описание первой заявки"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenDeleteOneItemThenTrackerHasAnotherValue() {
        Tracker tracker = new Tracker();
        Item firstitem = tracker.add(new Item("Первая заявка", "Описание первой заявки"));
        Item seconditem = tracker.add(new Item("Вторая заявка", "Описание второй заявки"));
        Input input = new StubInput(new String[]{"3", firstitem.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("Вторая заявка"));
    }

    @Test
    public void whenFindItemByIdThenItemWithSameName() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Первая", "Описание первой заявки"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
         new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("Первая"));
    }

    @Test
    public void whenShowAllItemThenCompareWithItems() {
        Tracker container = new Tracker();
        Item firstitem = new Item("first", "first", 123L);
        Item seconditem = new Item("second", "second", 123L);
        container.add(firstitem);
        container.add(seconditem);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, container).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringJoiner("\\r\\n", "", "\\r\\n")
                        .add("Меню.")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("Select:")
                        .add("------------ Актуальный список заявок --------------")
                        .add(firstitem.toString())
                        .add(seconditem.toString())
                        .add("------------ Конец списка --------------")
                        .add("Меню.")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("Select:").toString()
                           ));
    }

    @Test
    public void whenFindItemByNameThenItemWithSameName() {
        Tracker container = new Tracker();
        Item firstitem = new Item("first", "first", 123L);
        container.add(firstitem);
        Input input = new StubInput(new String[]{"5", "first", "6"});
        new StartUI(input, container).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringJoiner("\\r\\n", "", "\\r\\n")
                        .add("Меню.")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("Select:")
                        .add("------------ Поиск заявки по имени --------------")
                        .add("Заявка найдена: " + firstitem.toString())
                        .add("------------ Конец поиска по имени --------------")
                        .add("Меню.")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("Select:").toString()
                ));
    }

    @Before
    public void streamToByteArray() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void streamToOut() {
        System.setOut(this.stout);
    }
}

package ru.job4j.tracker;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * This is test class for StartUI.
 * @author Svyatoslav Sabirov.
 * @since 05.02.2018
 * @version $id$.
 */
public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("Первая заявка", "Описание первой заявки"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenDeleteOneItemThenTrackerHasAnotherValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item firstitem = tracker.add(new Item("Первая заявка", "Описание первой заявки"));
        Item seconditem = tracker.add(new Item("Вторая заявка", "Описание второй заявки"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"3", firstitem.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll()[0].getName(), is("Вторая заявка"));
    }

    @Test
    public void whenFindItemByIdThenItemWithSameName() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("Первая", "Описание первой заявки"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("Первая"));
    }
}

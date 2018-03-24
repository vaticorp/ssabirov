package ru.job4j.own;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for ThreadPool.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 19.03.2018.
 */
public class ThreadPoolTest {

    @Test
    public void whenAddWorksAndRun() throws InterruptedException {
        ThreadPool testPool = new ThreadPool();
        testPool.activatePool();
        testPool.add(new Work("Мыть посуду"));
        testPool.add(new Work("Красить окна"));
        testPool.add(new Work("Завтракать"));
        testPool.add(new Work("Обедать"));
        testPool.add(new Work("Шить одежду"));
        testPool.add(new Work("Управлять автомобилем"));
        testPool.add(new Work("Заниматься спортос"));
        testPool.add(new Work("Покупать продукты"));
        testPool.add(new Work("Подметать в доме"));
        testPool.add(new Work("Гулять с собакой"));
        testPool.add(new Work("Петь на сцене"));
        testPool.add(new Work("Пылесосить комнату"));
        testPool.add(new Work("Читать книгу"));
        testPool.add(new Work("Смотреть фильм"));
        Thread.sleep(5000);
    }
}
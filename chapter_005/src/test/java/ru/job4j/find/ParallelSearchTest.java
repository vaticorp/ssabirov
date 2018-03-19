package ru.job4j.find;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for ParallelSearch.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 19.03.2018.
 */
public class ParallelSearchTest {
    @Test
    public void whenWeFindWord() throws InterruptedException {
        ArrayList<String> ext = new ArrayList<String>();
        Collections.addAll(ext, "txt", "xlsx");
        ParallelSearch testFind = new ParallelSearch("D:\\test", "doom", ext);
        testFind.init();
        Thread.sleep(2000);
        List<String> awnser = testFind.result();
        for (String current : awnser) {
            System.out.println(current);
        }
    }
}
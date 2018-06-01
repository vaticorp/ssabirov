package ru.job4j.task;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for DepartmentTest.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 28.02.2018.
 */
public class DepartmentTest {
    @Test
    public void whenWeHaveOnlyArrayAndSortAsc() {
        Department sortDepartment = new Department();
        String[] department = new String[7];
        department[0] = "K1\\SK1";
        department[1] = "K1\\SK2";
        department[2] = "K1\\SK1\\SSK1";
        department[3] = "K1\\SK1\\SSK2";
        department[4] = "K2";
        department[5] = "K2\\SK1\\SSK1";
        department[6] = "K2\\SK1\\SSK2";
        assertThat("K1", is(sortDepartment.sort(department, true).get(0)));
    }
    @Test
    public void whenWeHaveOnlyArrayAndSortDesc() {
        Department sortDepartment = new Department();
        String[] department = new String[7];
        department[0] = "K1\\SK1";
        department[1] = "K1\\SK2";
        department[2] = "K1\\SK1\\SSK1";
        department[3] = "K1\\SK1\\SSK2";
        department[4] = "K2";
        department[5] = "K2\\SK1\\SSK1";
        department[6] = "K2\\SK1\\SSK2";
        assertThat("K2", is(sortDepartment.sort(department, false).get(0)));
    }
}

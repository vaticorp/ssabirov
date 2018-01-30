package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This test-class for Union
 */
public class UnionTest {

    @Test
    public void whenHaveTwoArrays() {
        Union union = new Union();
        int[] firstarray = new int[]{1,2,55,254,678,999};
        int[] secondarray = new int[]{4,6,77,253,800,995,1234,1500};
        int[] unionarrays = union.unionarrays(firstarray, secondarray);
        int[] expectedarrays = new int[] {1, 2, 4, 6, 55, 77, 253, 254, 678, 800, 995, 999, 1234, 1500};
        assertThat(expectedarrays, is(unionarrays));
    }

}

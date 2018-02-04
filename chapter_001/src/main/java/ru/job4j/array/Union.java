package ru.job4j.array;

/**
 * This method union result of two sorting arrays.
 * @author Svyatoslav Sabirov.
 * @since 30.01.2018
 * @version $id$.
 */
public class Union {

    public int[] unionarrays(int[] firstarray, int[] secondarray) {
        int[] resultarray = new int[firstarray.length + secondarray.length];
        int firstindex  = 0;
        int secondindex = 0;
        for (int curientindex = 0; curientindex < resultarray.length; curientindex++) {
            if (firstindex == firstarray.length) {
                resultarray[curientindex] = secondarray[secondindex];
                secondindex++;
            } else if (secondindex == secondarray.length) {
                resultarray[curientindex] = firstarray[firstindex];
                firstindex++;
            } else if (firstarray[firstindex] <= secondarray[secondindex]) {
                resultarray[curientindex] = firstarray[firstindex];
                firstindex++;
            } else {
                resultarray[curientindex] = secondarray[secondindex];
                secondindex++;
            }
        }
        return resultarray;
    }
}
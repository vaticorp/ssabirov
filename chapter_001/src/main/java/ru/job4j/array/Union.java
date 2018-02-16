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
        while (firstindex < firstarray.length && secondindex < secondarray.length) {
            if (firstarray[firstindex] <= secondarray[secondindex]) {
                resultarray[firstindex + secondindex] = firstarray[firstindex];
                firstindex++;
            } else {
                resultarray[firstindex + secondindex] = secondarray[secondindex];
                secondindex++;
            }
        }
        if (firstindex < firstarray.length) {
            System.arraycopy(firstarray, firstindex, resultarray, firstindex + secondindex, resultarray.length - (firstindex + secondindex));
        }
        if (secondindex < secondarray.length) {
            System.arraycopy(secondarray, secondindex, resultarray, firstindex + secondindex, resultarray.length - (firstindex + secondindex));
        }
        return resultarray;
    }
}
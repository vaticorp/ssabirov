package ru.job4j.array;

/**
 * This is task for advance level.
 * @author Svyatoslav Sabirov.
 * @since 28.01.2018
 * @version $id$.
 */
public class StringContain {
    /**
     * We using byte array fo search.
     * @param origin - initial string.
     * @param sub - search string.
     * @return boolean-result.
     */
    boolean contains(String origin, String sub) {
        int coincidence = 0;
        boolean result = false;
        char[] arrayorigin = origin.toCharArray();
        char[] arraysub = sub.toCharArray();
        for (int j = 0; j < arrayorigin.length; j++) {
            if (arraysub[coincidence] == arrayorigin[j]) {
                coincidence++;
            } else {
                coincidence = 0;
                if (arraysub[coincidence] == arrayorigin[j]) {
                    coincidence++;
                }
            }
            if (coincidence == arraysub.length) {
                result = true;
                break;
            }
        }
        return result;
    }
}

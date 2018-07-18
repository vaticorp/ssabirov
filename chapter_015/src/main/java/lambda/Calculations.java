package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * This class represents common interface.
 * @author Svyatoslav Sabirov.
 * @since 18.07.2018
 * @version 7.
 */
public interface Calculations {

    static List<Double> diapason(int start, int end, Function<Integer,Double> func) {
        List<Double> resultList = new ArrayList<Double>();
        for (int i = start; i <= end; i++) {
            resultList.add(func.apply(i));
        }
        return resultList;
    }
    List<Double> calculate(int start, int end);
}

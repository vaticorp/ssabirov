package lambda;

import java.util.List;

/**
 * This class represents class for line-calculation
 * @author Svyatoslav Sabirov.
 * @since 18.07.2018
 * @version 9.
 */
public class Line implements Calculations {

    @Override
    public List<Double> calculate(int start, int end) {
        List<Double> resultList = Calculations.diapason(start, end, x -> x + 2.0);
        return resultList;
    }
}

package lambda;

import java.util.List;

/**
 * This class represents Quadratic-function.
 * @author Svyatoslav Sabirov.
 * @since 18.07.2018
 * @version 9.
 */
public class Quadratic implements Calculations {

    @Override
    public List<Double> calculate(int start, int end) {
        List<Double> resultList = Calculations.diapason(start, end, x -> x * x + x + 1.0);
        return resultList;
    }
}

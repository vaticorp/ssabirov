package lambda;

import java.util.List;

/**
 * This class represents logarithmic-example.
 * @author Svyatoslav Sabirov.
 * @since 18.07.2018
 * @version 7.
 */
public class Logarithmic implements Calculations{
    @Override
    public List<Double> calculate(int start, int end) {
        List<Double> resultList = Calculations.diapason(start, end, x -> Math.log(x));
        return resultList;
    }
}

package lambda;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;


public class LineTest {

    @Test
    public void whenWeUseLine() {
        Calculations value = new Line();
        value.calculate(1, 6).forEach(s -> System.out.println(s));
    }

    @Test
    public void whenWeUseQuadratic() {
        Calculations value = new Quadratic();
        value.calculate(1, 6).forEach(s -> System.out.println(s));
    }

    @Test
    public void whenWeUseLogarithmic() {
        Calculations value = new Logarithmic();
        value.calculate(1, 6).forEach(s -> System.out.println(s));
    }
}
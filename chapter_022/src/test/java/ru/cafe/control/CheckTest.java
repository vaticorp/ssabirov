package ru.cafe.control;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.annotation.ElementType;

import ru.cafe.entity.Accessory;
import ru.cafe.entity.Additive;
import ru.cafe.entity.BaseProduct;
import ru.cafe.entity.Beverage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * This class represents test-class for check.
 * @author Svyatoslav Sabirov.
 * @since 01.12.2018
 * @version 12.
 */
public class CheckTest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenWeAddTwoPositionThenSum500() {
        Check check       = new CheckImp();
        Position firstPosition   = new Position();
        Position secondPosition  = new Position();
        Additive firstAdditive   = new Additive(new BaseProduct(100, "812368", "Молоко"));
        Accessory firstAccessory = new Accessory(new BaseProduct(50, "812777", "Зонтик"));
        Beverage firstBeverage   = new Beverage(new BaseProduct(100, "352996", "Черный чай"));
        firstPosition.setBeverage(firstBeverage);
        firstPosition.addAdditive(firstAdditive);
        firstPosition.addAccessory(firstAccessory);
        check.addCheck(firstPosition);
        Beverage secondBeverage  = new Beverage(new BaseProduct(250, "623571", "Кофе Капучинно"));
        secondPosition.setBeverage(secondBeverage);
        check.addCheck(secondPosition);
        assertThat(500.0, is(check.getTotalSum()));
    }

    @Test
    public void whenWeAddOnePositionThenPrint()  {
        Check check       = new CheckImp(1);
        Position secondPosition  = new Position();
        Beverage secondBeverage  = new Beverage(new BaseProduct(250, "623571", "Кофе Капучинно"));
        secondPosition.setBeverage(secondBeverage);
        check.addCheck(secondPosition);
        check.printCheck();
        StringBuilder result = new StringBuilder();
        result.append("------ Кассовый чек №1 ------")
                .append("\r").append("\n")
              .append("1 (напиток) * (623571) Кофе Капучинно - 250,00")
              .append("\n").append("\r").append("\n")
              .append("СУММА ИТОГО: 250.0").append("\r").append("\n").append("------- КОНЕЦ ------");
        assertThat(new String(this.out.toByteArray()), is(result.toString()));
    }
}


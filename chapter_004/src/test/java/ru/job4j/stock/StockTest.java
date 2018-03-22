package ru.job4j.stock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for Stock.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 12.03.2018.
 */
public class StockTest {

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
    public void whenAddTwoBidsToStockAndDelete() {
        Stock glass = new Stock();
        Proposal gazpromFirst = new Proposal("gazprom", Type.ADD, Action.ASK, 15, 20);
        Proposal deleteGazprom = new Proposal("gazprom", Type.DELETE, Action.ASK, 15, 20);
        Proposal lukoil = new Proposal("lukoil", Type.ADD, Action.ASK, 25, 15);
        glass.addBid(gazpromFirst);
        glass.addBid(lukoil);
        glass.addBid(deleteGazprom);
        glass.printStock();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Биржевой стакан для lukoil")
                                .append("\n")
                                .append("------------------------------")
                                .append("\n")
                                .append("Продажа Цена Покупка")
                                .append("\n")
                                .append("15      25")
                                .append("\n")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenAddBidsToStockAndGroupBy() {
        Stock glass = new Stock();
        Proposal gazpromFirst = new Proposal("gazprom", Type.ADD, Action.ASK, 15, 20);
        Proposal gazpromSecond = new Proposal("gazprom", Type.ADD, Action.ASK, 25, 20);
        Proposal gazpromFours = new Proposal("gazprom", Type.ADD, Action.BID, 15, 13);
        Proposal lukoil = new Proposal("lukoil", Type.ADD, Action.ASK, 25, 15);
        glass.addBid(gazpromFirst);
        glass.addBid(gazpromSecond);
        glass.addBid(gazpromFours);
        glass.addBid(lukoil);
        glass.printStock();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Биржевой стакан для gazprom")
                                .append("\n")
                                .append("------------------------------")
                                .append("\n")
                                .append("Продажа Цена Покупка")
                                .append("\n")
                                .append("20      25")
                                .append("\n")
                                .append("7      15")
                                .append("\n")
                                .append("Биржевой стакан для lukoil")
                                .append("\n")
                                .append("------------------------------")
                                .append("\n")
                                .append("Продажа Цена Покупка")
                                .append("\n")
                                .append("15      25")
                                .append("\n")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenAddBidsToStockAndCheck() {
        Stock glass = new Stock();
        Proposal gazpromFirst = new Proposal("gazprom", Type.ADD, Action.ASK, 15, 20);
        Proposal gazpromSecond = new Proposal("gazprom", Type.ADD, Action.ASK, 25, 20);
        Proposal gazpromFours = new Proposal("gazprom", Type.ADD, Action.BID, 15, 13);
        glass.addBid(gazpromFirst);
        glass.addBid(gazpromSecond);
        glass.addBid(gazpromFours);
        glass.printStock();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("Биржевой стакан для gazprom")
                                .append("\n")
                                .append("------------------------------")
                                .append("\n")
                                .append("Продажа Цена Покупка")
                                .append("\n")
                                .append("20      25")
                                .append("\n")
                                .append("7      15")
                                .append("\n")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}
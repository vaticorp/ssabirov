package ru.cafe.control;

import lombok.*;

import javax.print.attribute.standard.NumberUp;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents check-entity.
 * @author Svyatoslav Sabirov.
 * @since 30.11.2018
 * @version 7.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CheckImp implements Check {

    private List<Position> positions = new ArrayList<Position>();
    private long number;

    public CheckImp(long number) {
        this.number = number;
    }

    @Override
    public void addCheck(final Position position) {
        this.positions.add(position);
    }

    @Override
    public void printCheck() {
        int order = 1;
        System.out.println(String.format("------ Кассовый чек №%s ------", number));
        positions.forEach(position -> {
            System.out.println(String.format("%s %s", order, position.getDescription()));
        });
        System.out.println(String.format("СУММА ИТОГО: %s", this.getTotalSum()));
        System.out.print("------- КОНЕЦ ------");
    }

    @Override
    public double getTotalSum() {
        return positions.stream().mapToDouble(position -> position.getTotalSum()).sum();
    }
}

package ru.cafe.control;

import lombok.*;
import ru.cafe.entity.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents class for position.
 * @author Svyatoslav Sabirov.
 * @since 30.11.2018
 * @version 11.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Position {

    private Product beverage;
    private List<Product> additiveList = new ArrayList<Product>();
    private List<Product> accessoryList = new ArrayList<Product>();

    public void addAdditive(final Product additive) {
        this.additiveList.add(additive);
    }

    public void addAccessory(final Product accessory) {
        this.accessoryList.add(accessory);
    }

    public String getDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(beverage.getDescription()).append("\n");
        additiveList.forEach(additive -> {
            stringBuilder.append(additive.getDescription()).append("\n");
        });
        accessoryList.forEach(accessory -> {
            stringBuilder.append(accessory.getDescription()).append("\n");
        });
        return stringBuilder.toString();
    }

    public double getTotalSum() {
        double totalSum = 0F;
        totalSum += beverage.calculatePrice();
        totalSum += additiveList.stream().mapToDouble(p -> p.calculatePrice()).sum();
        totalSum += accessoryList.stream().mapToDouble(p -> p.calculatePrice()).sum();
        return totalSum;
    }
}

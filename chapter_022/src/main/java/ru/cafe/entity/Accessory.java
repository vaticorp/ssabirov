package ru.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class represents all kind of Accessory.
 * we will use a wrapper for each Accessory.
 * @author Svyatoslav Sabirov.
 * @since 01.12.2018
 * @version 7.
 */
@AllArgsConstructor
@Getter
public class Accessory implements Product {

    private final BaseProduct baseProduct;

    @Override
    public String getDescription() {
        return String.format("(%s) %s", "аксессуар", baseProduct.getDescription());
    }

    @Override
    public double calculatePrice() {
        return baseProduct.calculatePrice();
    }
}

package ru.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class represents base-class for product.
 * @author Svyatoslav Sabirov.
 * @since 01.12.2018
 * @version 7.
 */
@AllArgsConstructor
@Getter
public class BaseProduct implements Product {

    private double price;
    private String code;
    private String description;

    @Override
    public String getDescription() {
        return String.format("* (%s) %s - %.2f", this.code, this.description, calculatePrice());
    }

    @Override
    public double calculatePrice() {
        return this.price;
    }
}

package ru.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.cafe.properties.PropertyRepository;

/**
 * This class represents class for all kind of tea/coffee.
 * we will use a wrapper for each Beverage.
 * @author Svyatoslav Sabirov.
 * @since 01.12.2018
 * @version 10.
 */
@AllArgsConstructor
@Getter
public class Beverage implements Product {

    private final BaseProduct baseProduct;
    private PropertyRepository propertyRepository;

    public Beverage(BaseProduct baseProduct) {
        this.baseProduct = baseProduct;
    }

    @Override
    public String getDescription() {
        return String.format("(%s) %s", "напиток", baseProduct.getDescription());
    }

    @Override
    public double calculatePrice() {
        return baseProduct.calculatePrice();
    }
}

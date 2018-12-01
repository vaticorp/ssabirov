package ru.cafe.entity;

/**
 * This class represents common interface for simple actions.
 * @author Svyatoslav Sabirov.
 * @since 01.12.2018
 * @version 7.
 */
public interface Product {
    String getDescription();
    double calculatePrice();
}

package ru.cafe.properties;

import java.util.HashMap;
import java.util.Set;

/**
 * This class represents repository for properties.
 * @author Svyatoslav Sabirov.
 * @since 01.12.2018
 * @version 7.
 */
public interface PropertyRepository<T> {
    void setProperty(String name, T value);
    T getProperty(String name);
    Set<String> getPropertyNames();
    void removeProperty(String name);
    void removeProperties();
}

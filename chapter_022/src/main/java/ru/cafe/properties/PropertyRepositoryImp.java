package ru.cafe.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.cafe.exceptions.PropertyNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class represents class for current property.
 * @author Svyatoslav Sabirov.
 * @since 01.12.2018
 * @version 7.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PropertyRepositoryImp implements PropertyRepository<Property> {

    private Map<String, Property> mapOfProperties = new HashMap<String, Property>();

    @Override
    public void setProperty(final String name, final Property value) {
        if (name == null) {
            return;
        }
        this.mapOfProperties.putIfAbsent(name, value);
    }

    @Override
    public Property getProperty(final String name) {
        if (name == null || !this.mapOfProperties.containsKey(name)) {
            throw new PropertyNotFoundException("Свойство не найдено!");
        }
        return this.mapOfProperties.get(name);
    }

    @Override
    public Set<String> getPropertyNames() {
        return this.mapOfProperties.keySet();
    }

    @Override
    public void removeProperty(final String name) {
        this.mapOfProperties.remove(name);
    }

    @Override
    public void removeProperties() {
        this.mapOfProperties.clear();
    }
}

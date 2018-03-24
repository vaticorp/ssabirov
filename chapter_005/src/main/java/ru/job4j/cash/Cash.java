package ru.job4j.cash;

import java.util.concurrent.ConcurrentHashMap;

/**
 * This class represents simple cash.
 * @author Svyatoslav Sabirov.
 * @since 20.03.2018
 * @version 7.
 */
public class Cash {

    private ConcurrentHashMap<People, Integer> innerCashContainer = new ConcurrentHashMap();

    public void add(People model) {
        innerCashContainer.put(model, model.getVersion());
    }

    public void update(People model, String name) {
        innerCashContainer.computeIfPresent(model, (key, oldVal) -> {
            if (key.getVersion() != model.getVersion()) {
                throw new OplimisticException("Раличаются версии объекта!");
            }
            key.setName(name);
            oldVal++;
            return oldVal;
        });
    }

    public void delete(People model) {
        innerCashContainer.computeIfPresent(model, (key, oldVal) -> {
            innerCashContainer.remove(key);
            return null;
        });
    }

    @Override
    public String toString() {
        return "Cash{" + "innerCashContainer=" + innerCashContainer + '}';
    }
}

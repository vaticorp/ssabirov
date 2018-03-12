package ru.job4j.ownmap;

import java.util.Arrays;
import java.util.Iterator;

/**
 * This class represents map - realisation.
 * @author Svyatoslav Sabirov.
 * @since 09.03.2018
 * @version 7.
 */
public class MapHash<K, V> implements Iterable<MapValue<K, V>> {

    private MapValue<K, V>[] innerMap = new MapValue[10];
    private int size;

    public void checkSize() {
        if (size == innerMap.length) {
            increaseArray();
        }
    }

    public int getSize() {
        return size;
    }

    public void increaseArray() {
        this.innerMap = Arrays.copyOf(this.innerMap, this.innerMap.length * 2);
    }

    public boolean insert(K key, V value) {
        checkSize();
        int index = getIndexByKey(key);
        if (innerMap[index] != null) {
            return false;
        }
        innerMap[index] = new MapValue(key, value);
        return true;
    }

    public int getIndexByKey(K key) {
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % innerMap.length;
        return index;
    }

    public MapValue<K, V> getMapValue(K key) {
        MapValue<K, V> currentValue;
        int index = getIndexByKey(key);
        currentValue = innerMap[index];
        if (currentValue == null) {
            throw new NoKeyException("Отсутствует значение по ключу!");
        }
        return currentValue;
    }

    public V get(K key) {
        MapValue<K, V> currentValue = getMapValue(key);
        return currentValue.getValue();
    }

    public boolean delete(K key) {
        int index = getIndexByKey(key);
        if (innerMap[index] == null) {
            throw new NoKeyException("Отсутствует значение по ключу!");
        }
        innerMap[index] = null;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (MapValue<K, V> map : this.innerMap) {
            if (map == null) {
                continue;
            }
            str.append(map.getKey())
                .append(" : ")
                .append(map.getValue())
                .append("\n");
        }
        return str.toString();
    }

    @Override
    public Iterator<MapValue<K, V>> iterator() {
        return new Iterator<MapValue<K, V>>() {

            private int innerIterator;

            @Override
            public boolean hasNext() {
                return getNextValue(false) != null;
            }

            public MapValue<K, V> getNextValue(boolean moveIndex) {
                MapValue result = null;
                for (int index = innerIterator; index < innerMap.length; index++) {
                    if (innerMap[index] != null) {
                        result = innerMap[index];
                        if (moveIndex) {
                            innerIterator = index;
                        }
                        break;
                    }
                }
                return result;
            }

            @Override
            public MapValue<K, V> next() {
                MapValue result =  getNextValue(true);
                if (result == null) {
                    throw new IndexOutOfBoundsException();
                }
                return result;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

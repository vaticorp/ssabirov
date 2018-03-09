package ru.job4j.ownmap;

public class MapValue<K, V> {
    private K key;
    private V value;

    public MapValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
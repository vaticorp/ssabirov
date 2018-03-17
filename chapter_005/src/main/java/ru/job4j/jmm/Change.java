package ru.job4j.jmm;

public class Change {

    private int value;
    public Change(int value) {
        this.value = value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}

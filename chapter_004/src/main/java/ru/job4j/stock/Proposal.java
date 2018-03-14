package ru.job4j.stock;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * This class represents Proposal.
 * @author Svyatoslav Sabirov.
 * @since 12.03.2018
 * @version 7.
 */
public class Proposal {

    private int id;
    private String book;
    private Type type;
    private Action action;
    private int price;
    private int volume;

    public Proposal(String book, Type type, Action action, int price, int volume) {
        this.id = this.hashCode();
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    public int getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Type getType() {
        return type;
    }

    public Action getAction() {
        return action;
    }

    public String getBook() {
        return book;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, action, price, volume);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Proposal)) {
            return false;
        }
        Proposal currentProposal = (Proposal) obj;
        return currentProposal.id == this.id
                && currentProposal.book == this.book
                && currentProposal.volume == this.volume
                && currentProposal.action.equals(this.action)
                && currentProposal.price == this.price;
    }
}

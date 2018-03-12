package ru.job4j.transfers;

import java.util.Objects;

/**
 * This class represents Account for User.
 * @author Svyatoslav Sabirov.
 * @since 25.02.2018
 * @version 7.
 */
public class Account {

    private double value;
    private String requisites;

    public Account(int value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean transferMoney(Account destination, double amount) {
        boolean result = false;
        if (amount <= this.value) {
            this.value -= amount;
            double currentMoney = destination.getValue();
            destination.setValue(currentMoney + amount);
            result = true;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Account)) {
            return false;
        }
        Account verifiableAccount = (Account) obj;
        return super.equals(obj) || this.requisites.equals(verifiableAccount.requisites);
    }
}

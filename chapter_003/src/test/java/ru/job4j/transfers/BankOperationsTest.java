package ru.job4j.transfers;

import org.junit.Test;

import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is simple test-class for BankOperations.
 * @author Svyatoslav Sabirov.
 * @since 25.02.2018.
 * @version $id$.
 */
public class BankOperationsTest {
    @Test
    public void whenTransfer100ToAnotherAccount() {
        BankOperations transaction = new BankOperations();
        User leo = new User("Leo", "4002543123");
        User max = new User("Max", "4232543129");
        transaction.addUser(leo);
        transaction.addUser(max);
        Account leoAccount = new Account(1000, "Спб");
        Account maxAccount = new Account(2000, "Mck");
        transaction.addAccountToUser("4002543123", leoAccount);
        transaction.addAccountToUser("4232543129", maxAccount);
        assertThat(true, is(transaction.transferMoney("4002543123", "Спб", "4232543129", "Mck", 400)));
    }
}

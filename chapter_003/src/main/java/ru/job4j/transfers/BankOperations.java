package ru.job4j.transfers;

import java.util.*;

/**
 * This class represents bank operation
 * @author Svyatoslav Sabirov.
 * @since 25.02.2018
 * @version 7.
 */
public class BankOperations {

    private Map<User, List<Account>> usersAccount = new LinkedHashMap<User, List<Account>>();

    public Map<User, List<Account>> getUsersAccount() {
        return this.usersAccount;
    }

    public void addUser(User currentUser) {
        this.usersAccount.putIfAbsent(currentUser, new ArrayList<Account>());
    }

    public void deleteUser(User currentUser) {
        this.usersAccount.remove(currentUser);
    }

    public void addAccountToUser(String passportData, Account accountUser) {
        User foundUser = getUserByPassport(passportData);
        if (foundUser != null) {
            List<Account> listAccounts = this.usersAccount.get(foundUser);
            if (!listAccounts.contains(accountUser)) {
                listAccounts.add(accountUser);
            }
        }
    }

    public void deleteAccountFromUser(String passportData, Account accountUser) {
        User foundUser = getUserByPassport(passportData);
        if (foundUser != null) {
            List<Account> listAccounts = this.usersAccount.get(foundUser);
            if (listAccounts.contains(accountUser)) {
                listAccounts.remove(accountUser);
            }
        }
    }

    public User getUserByPassport(String passportData) {
        User foundUser = this.usersAccount.entrySet().stream().filter(s -> s.getKey().getPassport().equals(passportData)).findAny().orElseGet(null).getKey();
        return foundUser;
    }

    public List<Account> getUserAccounts(String passportData) {
        List<Account> accounts = new ArrayList<Account>();
        User foundUser = getUserByPassport(passportData);
        if (foundUser != null) {
            accounts = this.usersAccount.get(foundUser);
        }
        return accounts;
    }

    public Account getUserAccountByRequisite(List<Account> accounts, String requisite) {
        return accounts.stream().filter(s -> s.getRequisites().equals(requisite)).findAny().orElseGet(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        List<Account>  sourceUserAccounts = getUserAccounts(srcPassport);
        List<Account>  destinationUserAccounts = getUserAccounts(destPassport);
        Account sourceAccount = getUserAccountByRequisite(sourceUserAccounts, srcRequisite);
        Account destinationAccount = getUserAccountByRequisite(destinationUserAccounts, dstRequisite);
        if (sourceAccount != null && destinationAccount != null) {
            result = sourceAccount.transferMoney(destinationAccount, amount);
            if (result) {
                addAccountToUser(srcPassport, sourceAccount);
                addAccountToUser(destPassport, destinationAccount);
            }
        }
        return result;
    }
}

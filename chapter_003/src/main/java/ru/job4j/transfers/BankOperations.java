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

    public synchronized void deleteUser(User currentUser) {
        this.usersAccount.remove(currentUser);
    }

    public synchronized void addAccountToUser(String passportData, Account accountUser) {
        User foundUser = getUserByPassport(passportData);
        if (foundUser != null) {
            List<Account> listAccounts = this.usersAccount.get(foundUser);
            int index = listAccounts.indexOf(accountUser);
            if (index != -1) {
                listAccounts.set(index, accountUser);
            } else {
                listAccounts.add(accountUser);
            }
            this.usersAccount.replace(foundUser, listAccounts);
        }
    }

    public synchronized void deleteAccountFromUser(String passportData, Account accountUser) {
        User foundUser = getUserByPassport(passportData);
        if (foundUser != null) {
            List<Account> listAccounts = this.usersAccount.get(foundUser);
            int index = listAccounts.indexOf(accountUser);
            if (index != -1) {
                listAccounts.remove(index);
                this.usersAccount.replace(foundUser, listAccounts);
            }
        }
    }

    public User getUserByPassport(String passportData) {
        User foundUser = null;
        for (Map.Entry<User, List<Account>> entryUser : this.usersAccount.entrySet()) {
            if (entryUser.getKey().getPassport().equals(passportData)) {
                foundUser = entryUser.getKey();
                break;
            }
        }
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
        Account findAccount = null;
        for (Account current : accounts) {
            if (current.getRequisites().equals(requisite)) {
                findAccount = current;
                break;
            }
        }
        return findAccount;
    }

    public synchronized boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
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

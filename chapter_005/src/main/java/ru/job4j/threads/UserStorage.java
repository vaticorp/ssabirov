package ru.job4j.threads;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class represents example of Storage.
 * @author Svyatoslav Sabirov.
 * @since 17.03.2018
 * @version 7.
 */
@ThreadSafe
public class UserStorage {

    @GuardedBy("this")
    private ArrayList<User> userList = new ArrayList<User>();
    private Lock storageLock = new ReentrantLock();

    public boolean add(User user) {
        synchronized (this) {
            return userList.add(user);
        }
    }

    public boolean update(User user, int id) {
        boolean result = false;
        synchronized (this) {
            int index = userList.indexOf(user);
            if (index != -1) {
                userList.get(index).setId(id);
                result = true;
            }
        }
        return result;
    }

    public boolean delete(User user) {
        synchronized (this) {
            return userList.remove(user);
        }
    }

    public User getUserById(int id) {
        User result = null;
        for (User current : userList) {
            if (current.getId() == id) {
                result = current;
                break;
            }
        }
        return result;
    }

    public boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        storageLock.lock(); //поставим блокировку
        try {
            User sender = getUserById(fromId);
            User recipient = getUserById(toId);
            if (sender != null && recipient != null) {
                int senderAmount = sender.getAmount();
                if (senderAmount >= amount) {
                    sender.setAmount(senderAmount - amount);
                    recipient.setAmount(recipient.getAmount() + amount);
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            storageLock.unlock(); //снимем текущую блокировку
        }
        return result;
    }
}


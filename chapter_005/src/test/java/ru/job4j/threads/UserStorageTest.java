package ru.job4j.threads;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This is test class for ListCompare.
 * @author Svatoslav Sabirov.
 * @version 11.
 * @since 17.03.2018.
 */
public class UserStorageTest {

    public class UserStorageThread extends Thread {

        private UserStorage innerStorage;
        private int number;

        public UserStorageThread(UserStorage innerStorage, int number) {
            this.innerStorage = innerStorage;
            this.number = number;
        }

        @Override
        public void run() {
            boolean result = false;
            result = innerStorage.transfer(1, 2, 50);
            System.out.println("Нить " + number + " пытается перевести 50$. Результат операции:" + result);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = innerStorage.transfer(1, 2, 50);
            System.out.println("Нить " + number + " пытается перевести 50$. Результат операции:" + result);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = innerStorage.transfer(1, 2, 50);
            System.out.println("Нить " + number + " пытается перевести 50$. Результат операции:" + result);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("На счету отправителя " + innerStorage.getUserById(1).getAmount() + "(Нить" + number + ")");
        }
    }

/*    @Test
    public void whenWeHaveSuccessTransfer() throws InterruptedException {
        UserStorage stoge = new UserStorage();
        stoge.add(new User(1, 100));
        stoge.add(new User(2, 200));
        UserStorageThread firstThread = new UserStorageThread(stoge, 1);
        UserStorageThread secondThread = new UserStorageThread(stoge, 2);
        firstThread.start();
        secondThread.start();
        Thread.sleep(5000);
    }*/
}
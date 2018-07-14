package ru.job4j.models;
import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * This class represents user-model.
 * @author Svyatoslav Sabirov.
 * @since 07.07.2018
 * @version 7.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "login")
    private String accountID;
    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(int id, String login, String password) {
        this.id = id;
        this.accountID = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void generatePassword(int from, int to) {
        String pass  = "";
        Random r     = new Random();
        int cntchars = from + r.nextInt(to - from + 1);
        for (int i = 0; i < cntchars; ++i) {
            char next = 0;
            int range = 10;
            switch(r.nextInt(3)) {
                case 0: {next = '0'; range = 10;} break;
                case 1: {next = 'a'; range = 26;} break;
                case 2: {next = 'A'; range = 26;} break;
            }
            pass += (char)((r.nextInt(range)) + next);
        }
        this.password = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", accountID='" + accountID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

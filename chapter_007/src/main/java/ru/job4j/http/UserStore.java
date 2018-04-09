package ru.job4j.http;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class represents UserStorage-singleton.
 * @author Svyatoslav Sabirov.
 * @since 06.04.2018
 * @version 7.
 */
public class UserStore {

    private volatile static UserStore instance;
    private UserStore() {

    }
    private final String url = "jdbc:postgresql://localhost:5432/user";
    private final String login = "postgres";
    private final String password = "1";

    public static UserStore getInstance() {
        if (instance == null) {
            synchronized (UserStore.class) {
                if (instance == null) {
                    instance = new UserStore();
                }
            }
        }
        return instance;
    }

    public User getUser(String userLogin) {
        User returnUser = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, login, password);
             PreparedStatement prpStat = connection.prepareStatement("SELECT name, login, email, createDate FROM users WHERE login = ?")) {
            prpStat.setString(1, userLogin);
            try (ResultSet rs = prpStat.executeQuery();) {
                while (rs.next()) {
                    returnUser = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4).toString());
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return returnUser;
    }

    public boolean deleteUser(String userLogin) {
        boolean result = false;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prpStat = connection.prepareStatement("DELETE FROM users WHERE login = ?")) {
            prpStat.setString(1, userLogin);
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public boolean updateUser(String userLogin, String userMail) {
        boolean result = false;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement prpStat = connection.prepareStatement("UPDATE users SET email= ? WHERE login = ?")) {
            prpStat.setString(1, userMail);
            prpStat.setString(2, userLogin);
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public boolean createUser(User newUser) {
        boolean result = false;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(url, login, password);
             PreparedStatement prpStat = connection.prepareStatement("INSERT INTO users(login, name, email, createdate) VALUES (?, ?, ?, ?)")) {
            prpStat.setString(1, newUser.getLogin());
            prpStat.setString(2, newUser.getName());
            prpStat.setString(3, newUser.getEmail());
            prpStat.setTimestamp(4, Timestamp.valueOf(newUser.getCreateDate()));
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
}

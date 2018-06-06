package ru.job4j.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This class represents jdbc-storage.
 * @author Svyatoslav Sabirov.
 * @since 06.06.2018
 * @version 7.
 */
@Component
public class JdbcStorage implements Storage {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcStorage.class);
    private String url;
    private String login;
    private String password;

    public JdbcStorage(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public JdbcStorage() {
        readProperty();
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void readProperty() {
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream("chapter_012/src/main/resources/config.properties");) {
            property.load(fis);
            url = property.getProperty("url");
            login = property.getProperty("login");
            password = property.getProperty("password");
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public void add(User user) {
        try (Connection con = DriverManager.getConnection(this.getUrl(), this.getLogin(), this.getPassword());
             PreparedStatement stmt = con.prepareStatement("INSERT INTO users(name) VALUES (?)");) {
            stmt.setString(1, user.getName());
            stmt.execute();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        JdbcStorage test = new JdbcStorage();
        User user = new User();
        user.setName("Yulia");
        test.add(user);
    }
}

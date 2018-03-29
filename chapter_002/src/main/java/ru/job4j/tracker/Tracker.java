package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.postgresql.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 * This class is using for storage items.
 * @author Svytoslav Sabirov.
 * @since 27.02.2018
 */
public class Tracker {

    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<Item>();
    private final Logger logger = LoggerFactory.getLogger(Tracker.class);
    private final Map<String, String> scripts = new HashMap<>();
    private String url;
    private String user;
    private String password;

    public Tracker() {

        FileInputStream fis = null;
        Properties property = new Properties();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            fis = new FileInputStream("chapter_002/src/main/java/ru/job4j/tracker/config.properties");
            property.load(fis);
            url = property.getProperty("url");
            user = property.getProperty("login");
            password = property.getProperty("password");
            scripts.put("add", property.getProperty("add"));
            scripts.put("replace", property.getProperty("replace"));
            scripts.put("delete", property.getProperty("delete"));
            scripts.put("findAll", property.getProperty("findAll"));
            scripts.put("findByName", property.getProperty("findByName"));
            scripts.put("findById", property.getProperty("findById"));

            Connection con = DriverManager.getConnection(url, user, password);
            stmt = con.prepareStatement(property.getProperty("checkStructure"));
            rs = stmt.executeQuery();
            if (!rs.next()) {
                con.prepareStatement(property.getProperty("createStructure"));
                stmt.execute();
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                fis.close();
            } catch (IOException ioException) {
                logger.error(ioException.getMessage(), ioException);
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
            try {
                rs.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
        }
    }


    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = scripts.get("add");
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.prepareStatement(query);
            stmt.setString(1, this.generateId());
            stmt.setString(2, item.getName());
            stmt.setString(3, item.getDescription());
            stmt.setLong(4, item.getCreated());
            stmt.execute();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
        }
        return item;
    }

    /**
     * Method for edit item.
     * @param id - identifier.
     * @param item - bid.
     */
    public void replace(String id, Item item) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = scripts.get("replace");
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.prepareStatement(query);
            stmt.setString(1, item.getName());
            stmt.setString(2, item.getDescription());
            stmt.setLong(3, item.getCreated());
            stmt.setString(4, id);
            stmt.execute();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
        }
    }
    /**
     * Delete by bid-id.
     * @param id - identifier.
     */
    public void delete(String id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = scripts.get("delete");
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            stmt.execute();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
        }
    }

    /**
     * Get list of bid.
     * @return - list of bid.
     */
    public List<Item> findAll() {
        List<Item> list = new ArrayList<Item>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = scripts.get("findAll");
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString(2), rs.getString(3), rs.getLong(4));
                item.setId(rs.getString(1));
                list.add(item);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
            try {
                rs.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
        }
        return list;
    }

    /**
     * Get list by name;
     * @param key - bid-name;
     * @return bid-list.
     */
    public List<Item> findByName(String key) {
        List<Item> currientitems = new ArrayList<Item>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = scripts.get("findByName");
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.prepareStatement(query);
            stmt.setString(1, key);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString(2), rs.getString(3), rs.getLong(4));
                item.setId(rs.getString(1));
                currientitems.add(item);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
            try {
                rs.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
        }
        return currientitems;
    }

    /**
     * Get bid by id.
     * @param id
     * @return bid.
     */
    public Item findById(String id) {
        Item found = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = scripts.get("findByName");
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                found = new Item(rs.getString(2), rs.getString(3), rs.getLong(4));
                found.setId(rs.getString(1));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
            try {
                stmt.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
            try {
                rs.close();
            } catch (SQLException se) {
                logger.error(se.getMessage(), se);
            }
        }
        return found;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + (int) (Math.random() * 3));
    }
}

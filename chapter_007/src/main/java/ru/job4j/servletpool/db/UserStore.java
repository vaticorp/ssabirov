package ru.job4j.servletpool.db;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import ru.job4j.servletpool.model.Role;
import ru.job4j.servletpool.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents db-connector.
 * @author Svyatoslav Sabirov.
 * @since 13.04.2018
 * @version 14.
 */
public enum UserStore {
    INSTANCE;
    private final PoolingDataSource dataSource = initPoolingDataSource();
    private PoolingDataSource initPoolingDataSource() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DriverManagerConnectionFactory connFactory = new DriverManagerConnectionFactory("jdbc:postgresql://localhost:5432/servlet", "postgres", "1");
        PoolableConnectionFactory poolFactory=new PoolableConnectionFactory(connFactory,new GenericObjectPool(),null,null,false,true);
        PoolingDataSource poolDs = new PoolingDataSource(poolFactory.getPool());
        return poolDs;
    }

    public boolean deleteUser(String userLogin) {
        boolean result = false;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("DELETE FROM users WHERE login = ?")) {
            prpStat.setString(1, userLogin);
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public User getUser(String userLogin) {
       User returnUser = null;
       try (Connection connection = dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("SELECT us.name, us.login, us.email,us.password,us.role, rl.description FROM users as us left outer join roles as rl on us.role = rl.name WHERE login = ?")) {
            prpStat.setString(1, userLogin);
            try (ResultSet rs = prpStat.executeQuery();) {
                while (rs.next()) {
                    returnUser = new User(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),new Role(rs.getString(5),rs.getString(6)));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return returnUser;
    }

    public List<User> getUsers() {
        List<User> userList = new ArrayList<User>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("SELECT us.name, us.login, us.email,us.password,us.role, rl.description FROM users as us left outer join roles as rl on us.role = rl.name")) {
            try (ResultSet rs = prpStat.executeQuery();) {
                while (rs.next()) {
                    userList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),new Role(rs.getString(5),rs.getString(6))));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return userList;
    }

    public boolean createUser(User newUser) {
        boolean result = false;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("INSERT INTO users(login, name, email,password,role) VALUES (?, ?, ?, ?, ?)")) {
            prpStat.setString(1, newUser.getLogin());
            prpStat.setString(2, newUser.getName());
            prpStat.setString(3, newUser.getEmail());
            prpStat.setString(4, newUser.getPassword());
            prpStat.setString(5, newUser.getRole().getName());
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

        public boolean createRole(Role role) {
        boolean result = false;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("INSERT INTO roles(name, description) VALUES (?, ?)")) {
            prpStat.setString(1, role.getName());
            prpStat.setString(2, role.getDescription());
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public boolean deleteRole(String name) {
        boolean result = false;
        try (Connection connection = dataSource.getConnection();
            PreparedStatement prpStat = connection.prepareStatement("DELETE FROM roles WHERE name = ?")) {
            prpStat.setString(1, name);
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public boolean updateUser(String userLogin, String userMail, String name) {
        boolean result = false;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("UPDATE users SET name=?, email= ? WHERE login = ?")) {
            prpStat.setString(1, name);
            prpStat.setString(2, userMail);
            prpStat.setString(3, userLogin);
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public boolean userValid(String login, String password) {
        boolean result = false;
        try (Connection connection = dataSource.getConnection();
            PreparedStatement prpStat = connection.prepareStatement("SELECT name FROM users WHERE login = ? and password = ?")) {
            prpStat.setString(1, login);
            prpStat.setString(2, password);
            try (ResultSet rs = prpStat.executeQuery();) {
                result = rs.next();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
}

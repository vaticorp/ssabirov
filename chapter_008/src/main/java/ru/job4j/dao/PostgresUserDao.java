package ru.job4j.dao;

import ru.job4j.models.Address;
import ru.job4j.models.MusicType;
import ru.job4j.models.Role;
import ru.job4j.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents operations for User.
 * @author Svyatoslav Sabirov.
 * @since 05.05.2018
 * @version 11.
 */
public class PostgresUserDao implements CommonDao<User> {

    private final PostgresDAOFactory postgresDAO;

    public PostgresUserDao(PostgresDAOFactory postgresDAO) {
        this.postgresDAO = postgresDAO;
    }

    @Override
    public boolean create(User value) {
        boolean result = false;
        Role currentRole = value.getRole();
        Address currentAddress = value.getResidence();
        postgresDAO.getRoleDAO().create(currentRole);
        postgresDAO.getAddressDAO().create(currentAddress);
        try (Connection connection = postgresDAO.dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("INSERT INTO users(name, age, role, address_id) VALUES (?,?,?,?)")) {
            prpStat.setString(1, value.getName());
            prpStat.setInt(2, value.getAge());
            prpStat.setString(3, currentRole.getTitle());
            prpStat.setString(4, currentAddress.getId());
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> selectAll() {
       List<User> usersList = new ArrayList<User>();
       try (Connection connection = postgresDAO.dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("SELECT name, age, role, address_id FROM users")) {
            try (ResultSet rs = prpStat.executeQuery();) {
                while (rs.next()) {
                    Address address =  postgresDAO.getAddressDAO().select(rs.getString("address_id"));
                    Role role = postgresDAO.getRoleDAO().select(rs.getString("role"));
                    List<MusicType> list = PostgresMusicTypeDao.selectAllByUserID(rs.getString("name"));
                    usersList.add(new User(rs.getString("name"), rs.getInt("age"),role, address, list));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return usersList;
    }

    @Override
    public User select(String id) {
        User currentUser = null;
        try (Connection connection = postgresDAO.dataSource.getConnection();
            PreparedStatement prpStat = connection.prepareStatement("SELECT name, age, role, address_id FROM users WHERE name = ?")) {
            prpStat.setString(1, id);
            try (ResultSet rs = prpStat.executeQuery();) {
                while (rs.next()) {
                    Address address =  postgresDAO.getAddressDAO().select(rs.getString("address_id"));
                    Role role = postgresDAO.getRoleDAO().select(rs.getString("role"));
                    List<MusicType> list = PostgresMusicTypeDao.selectAllByUserID(rs.getString("name"));
                    currentUser = new User(rs.getString("name"), rs.getInt("age"),role, address, list);
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return currentUser;
    }

    @Override
    public boolean edit(User value) {
        boolean result = false;
        String name = value.getName();
        int age = value.getAge();
        try (Connection connection = postgresDAO.dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("UPDATE users SET age =? WHERE name = ?")) {
            prpStat.setString(2, name);
            prpStat.setInt(1, age);
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean remove(String id) {
        boolean result = false;
        try (Connection connection = postgresDAO.dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("DELETE FROM users WHERE name = ?")) {
            prpStat.setString(1, id);
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
}

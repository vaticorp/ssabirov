package ru.job4j.dao;

import ru.job4j.models.MusicType;
import ru.job4j.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents operations for Role.
 * @author Svyatoslav Sabirov.
 * @since 05.05.2018
 * @version 11.
 */
public class PostgresRoleDao implements CommonDao<Role> {

    @Override
    public boolean create(Role value) {
        boolean result = false;
        try (Connection connection = PostgresDAOFactory.dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("INSERT INTO roles(title, description) VALUES (?,?)")) {
            prpStat.setString(1, value.getTitle());
            prpStat.setString(2, value.getDescription());
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Role> selectAll() {
        List<Role> roleList = new ArrayList<Role>();
        try (Connection connection = PostgresDAOFactory.dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("SELECT title, description FROM roles")) {
            try (ResultSet rs = prpStat.executeQuery();) {
                while (rs.next()) {
                    roleList.add(new Role(rs.getString("title"), rs.getString("description")));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return roleList;
    }

    @Override
    public Role select(String id) {
        Role returnRole = null;
        try (Connection connection = PostgresDAOFactory.dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("SELECT title, description FROM roles WHERE title = ?")) {
            prpStat.setString(1, id);
            try (ResultSet rs = prpStat.executeQuery();) {
                while (rs.next()) {
                    returnRole = new Role(rs.getString("title"), rs.getString("description"));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return returnRole;
    }

    @Override
    public boolean edit(Role value) {
        boolean result = false;
        String title = value.getTitle();
        String description = value.getDescription();
        try (Connection connection = PostgresDAOFactory.dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("UPDATE roles SET description =? WHERE title = ?")) {
            prpStat.setString(2, title);
            prpStat.setString(1, description);
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
        try (Connection connection = PostgresDAOFactory.dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("DELETE FROM roles WHERE title = ?")) {
            prpStat.setString(1, id);
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
}

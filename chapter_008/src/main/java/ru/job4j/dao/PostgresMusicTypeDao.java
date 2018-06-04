package ru.job4j.dao;

import ru.job4j.models.MusicType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents operations for MusicType.
 * @author Svyatoslav Sabirov.
 * @since 05.05.2018
 * @version 11.
 */
public class PostgresMusicTypeDao implements CommonDao<MusicType> {

    @Override
    public boolean create(MusicType value) {
        boolean result = false;
        try (Connection connection = PostgresDAOFactory.DATASOURCE.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("INSERT INTO musictype(name) VALUES (?)")) {
            prpStat.setString(1, value.getName());
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    @Override
    public List<MusicType> selectAll() {
        List<MusicType> typeList = new ArrayList<MusicType>();
        try (Connection connection = PostgresDAOFactory.DATASOURCE.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("SELECT name FROM musictype")) {
            try (ResultSet rs = prpStat.executeQuery();) {
                while (rs.next()) {
                    typeList.add(new MusicType(rs.getString("name")));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return typeList;
    }

    public static List<MusicType> selectAllByUserID(String userId) {
        List<MusicType> typeList = new ArrayList<MusicType>();
        try (Connection connection = PostgresDAOFactory.DATASOURCE.getConnection();
            PreparedStatement prpStat = connection.prepareStatement("SELECT type FROM users_music where user_id =?")) {
            prpStat.setString(1, userId);
            try (ResultSet rs = prpStat.executeQuery();) {
                while (rs.next()) {
                    typeList.add(new MusicType(rs.getString("name")));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return typeList;
    }

    @Override
    public MusicType select(String id) {
        MusicType returnType = null;
        try (Connection connection = PostgresDAOFactory.DATASOURCE.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("SELECT name FROM musictype WHERE name = ?")) {
            prpStat.setString(1, id);
            try (ResultSet rs = prpStat.executeQuery();) {
                while (rs.next()) {
                    returnType = new MusicType(rs.getString("name"));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return returnType;
    }

    @Override
    public boolean edit(MusicType value) {
        boolean result = false;
        String name = value.getName();
        try (Connection connection = PostgresDAOFactory.DATASOURCE.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("UPDATE musictype SET name =? WHERE name = ?")) {
            prpStat.setString(2, name);
            prpStat.setString(1, name);
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
        try (Connection connection = PostgresDAOFactory.DATASOURCE.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("DELETE FROM musictype WHERE name = ?")) {
            prpStat.setString(1, id);
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
}

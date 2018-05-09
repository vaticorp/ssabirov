package ru.job4j.dao;

import ru.job4j.models.Address;
import ru.job4j.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents operations for Address.
 * @author Svyatoslav Sabirov.
 * @since 05.05.2018
 * @version 11.
 */
public class PostgresAddressDao implements CommonDao<Address> {

    @Override
    public boolean create(Address value) {
        boolean result = false;
        try (Connection connection = PostgresDAOFactory.dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("INSERT INTO address(id, city, street, flat) VALUES (?,?,?,?)")) {
            prpStat.setString(1, value.getId());
            prpStat.setString(2, value.getCity());
            prpStat.setString(3, value.getStreet());
            prpStat.setInt(4, value.getFlat());
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Address> selectAll() {
        List<Address> addressList = new ArrayList<Address>();
        try (Connection connection = PostgresDAOFactory.dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("SELECT id, city, street, flat FROM address")) {
            try (ResultSet rs = prpStat.executeQuery();) {
                while (rs.next()) {
                    addressList.add(new Address(rs.getString("id"), rs.getString("city"),rs.getString("street"), rs.getInt("flat")));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return addressList;
    }

    @Override
    public Address select(String id) {
        Address returnAddress = null;
        try (Connection connection = PostgresDAOFactory.dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("SELECT id, city, street, flat FROM address WHERE id = ?")) {
            prpStat.setString(1, id);
            try (ResultSet rs = prpStat.executeQuery();) {
                while (rs.next()) {
                    returnAddress = new Address(rs.getString("id"), rs.getString("city"),rs.getString("street"), rs.getInt("flat"));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return returnAddress;
    }

    @Override
    public boolean edit(Address value) {
        boolean result = false;
        String id = value.getId();
        String street = value.getStreet();
        try (Connection connection = PostgresDAOFactory.dataSource.getConnection();
             PreparedStatement prpStat = connection.prepareStatement("UPDATE address SET street =? WHERE id = ?")) {
            prpStat.setString(2, id);
            prpStat.setString(1, street);
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
             PreparedStatement prpStat = connection.prepareStatement("DELETE FROM address WHERE id = ?")) {
            prpStat.setString(1, id);
            prpStat.execute();
            result = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
}

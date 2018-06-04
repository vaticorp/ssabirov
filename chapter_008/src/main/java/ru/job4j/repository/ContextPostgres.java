package ru.job4j.repository;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import ru.job4j.models.Address;
import ru.job4j.models.Role;
import ru.job4j.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class represents db-connector
 * @author Svyatoslav Sabirov.
 * @since 07.05.2018
 * @version 7.
 */
public class ContextPostgres {

    public static final PoolingDataSource DATASOURCE = initPoolingDataSource();

    private static PoolingDataSource initPoolingDataSource() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DriverManagerConnectionFactory connFactory = new DriverManagerConnectionFactory("jdbc:postgresql://localhost:5432/musicbox", "postgres", "1");
        PoolableConnectionFactory poolFactory = new PoolableConnectionFactory(connFactory, new GenericObjectPool(), null, null, false, true);
        PoolingDataSource poolDs = new PoolingDataSource(poolFactory.getPool());
        return poolDs;
    }

    public void addUser(User value) {

    }

}

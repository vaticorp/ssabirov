package ru.job4j.dao;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import ru.job4j.models.Address;
import ru.job4j.models.MusicType;
import ru.job4j.models.Role;
import ru.job4j.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents postgres-source.
 * @author Svyatoslav Sabirov.
 * @since 05.05.2018
 * @version 12.
 */
public class PostgresDAOFactory extends DAOFactory {

    public static final PoolingDataSource dataSource = initPoolingDataSource();

    private static PoolingDataSource initPoolingDataSource() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DriverManagerConnectionFactory connFactory = new DriverManagerConnectionFactory("jdbc:postgresql://localhost:5432/musicbox", "postgres", "1");
        PoolableConnectionFactory poolFactory = new PoolableConnectionFactory(connFactory,new GenericObjectPool(),null,null,false,true);
        PoolingDataSource poolDs = new PoolingDataSource(poolFactory.getPool());
        return poolDs;
    }

    @Override
    public CommonDao<Role> getRoleDAO() {
        return new PostgresRoleDao();
    }

    @Override
    public CommonDao<Address> getAddressDAO() {
        return new PostgresAddressDao();
    }

    @Override
    public CommonDao<MusicType> getMusicTypeDAO() {
        return new PostgresMusicTypeDao();
    }

    @Override
    public CommonDao<User> getUserDAO() {
        return new PostgresUserDao(this);
    }

    public static void main(String[] args) {
        DAOFactory cloudscapeFactory = DAOFactory.getDaoFactory(DAOFactory.POSTGRES);
        CommonDao<Address> custDAO =  cloudscapeFactory.getAddressDAO();
        //custDAO.create(new Address("kud", "Kudrovo", "Evropeyskiy", 13));
        //custDAO.edit(new Address("test", "Piter", "Evropa", 38));
/*        Address current = custDAO.select("test");
        System.out.println(current.getCity());*/
/*        List<Address> list = custDAO.selectAll();
        for (Address current : list) {
            System.out.println(current.getCity());
        }*/
        //custDAO.remove("test");
    }
}

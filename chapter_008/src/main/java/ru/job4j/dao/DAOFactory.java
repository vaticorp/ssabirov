package ru.job4j.dao;

import ru.job4j.models.Address;
import ru.job4j.models.MusicType;
import ru.job4j.models.Role;
import ru.job4j.models.User;

/**
 * This class represents abstract-class for dao.
 * @author Svyatoslav Sabirov.
 * @since 05.05.2018
 * @version 7.
 */
public abstract class DAOFactory {

    public static final int POSTGRES = 1;

    /**
     * Метод возвращает тот dao-что нам нужен. Новая сущность добавляет нам новый метод,что не очень
     * уж и хорошо.Но я не смог придумать/найти схемы получше.
     */
    public abstract CommonDao<Role> getRoleDAO();
    public abstract CommonDao<Address> getAddressDAO();
    public abstract CommonDao<MusicType> getMusicTypeDAO();
    public abstract CommonDao<User> getUserDAO();

    /**
     * @param numberFactory - номер необходимого способа соединения.При необходимости добавить новый источник
     * - расширить метод.
     * @return - объект для работы с источником
     */
    public static DAOFactory getDaoFactory(int numberFactory) {
        switch (numberFactory) {
            case POSTGRES:
                return new PostgresDAOFactory();
            default:
                return null;
        }
    }
}

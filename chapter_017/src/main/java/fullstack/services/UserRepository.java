package fullstack.services;

import fullstack.models.User;
import java.util.List;

/**
 * This class represents interface for user-operations.
 * @author Svyatoslav Sabirov.
 * @since 11.09.2018
 * @version 10.
 */
public interface UserRepository  {
    List<User> getAllUsers();
    User getUserById(long id);
}

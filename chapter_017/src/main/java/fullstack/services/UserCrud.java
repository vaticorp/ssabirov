package fullstack.services;

import fullstack.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * This class represents interface for crud-operation.
 * @author Svyatoslav Sabirov.
 * @since 11.09.2018
 * @version 12.
 */
public interface UserCrud extends CrudRepository<User, Long> {
    @Query("select usr from User usr where usr.login =:login and usr.password =:password")
    User findByLoginPassword(@Param("login") String login, @Param("password") String password);
}

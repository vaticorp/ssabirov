package fullstack.models;

import com.sun.istack.internal.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * This class represents simple model-user.
 * @author Svyatoslav Sabirov.
 * @since 11.09.2018
 * @version 7.
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "login")
    @Size(max = 50,
          message = "Логин не может быть больше 20 символов"
    )
    private String login;
    @Column(name = "password")
    @Size(max = 50,
          message = "Логин не может быть больше 40 символов"
    )
    private String password;

    public User() {
    }

    public User(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

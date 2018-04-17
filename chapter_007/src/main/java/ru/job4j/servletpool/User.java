package ru.job4j.servletpool;

/**
 * This class represents User-dao.
 * @author Svyatoslav Sabirov.
 * @since 06.04.2018
 * @version 7.
 */
public class User {

    private String name;
    private String login;
    private String email;

    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

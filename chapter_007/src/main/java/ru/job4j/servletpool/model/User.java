package ru.job4j.servletpool.model;

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
    private String password;
    private Role role;

    public User(String name, String login, String email,String password, Role role) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
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

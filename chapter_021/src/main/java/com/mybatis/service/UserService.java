package com.mybatis.service;

import com.model.User;
import java.util.List;

/**
 * This class represents service-interface for user.
 * @author Svyatoslav Sabirov.
 * @since 23.11.2018
 * @version 12.
 */
public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void removeUser(User user);
    void addUser(User user);
    void updateUser(User user);
}

package com.mybatis.service;

import com.model.User;
import com.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * This class represents service for user.
 * @author Svyatoslav Sabirov.
 * @since 24.11.2018
 * @version 7.
 */
@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return this.userMapper.getListOfEntities();
    }

    @Override
    public User getUserById(Long id) {
        return this.userMapper.getEntityById(id);
    }

    @Override
    public void removeUser(User user) {
        this.userMapper.removeEntity(user);
    }

    @Override
    public void addUser(User user) {
        this.userMapper.addEntity(user);
    }

    @Override
    public void updateUser(User user) {
        this.userMapper.updateEntity(user);
    }
}

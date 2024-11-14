package com.nnd.service.impl;

import com.nnd.dao.UserDao;
import com.nnd.pojo.User;
import com.nnd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryAllUsers() {
        return userDao.queryAllUsers();
    }

    @Override
    public User queryUserById(int id) {
      return userDao.queryUserById(id);
    }

    @Override
    public boolean addUser(User user) {
        int row = userDao.addUser(user);
        if (row > 0) {
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteUserById(int id) {
        int row = userDao.deleteUserById(id);
        if (row > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
       int row=userDao.updateUser(user);
        if(row > 0){
            return true;
        }
    return false;
    }
    @Override
    public User userLogin(User user) {
        return userDao.userLogin(user);
    }
    public boolean registerUser(User user) {
        int rows = userDao.registerUser(user);
        if (rows > 0) {
            return true;
        }
        return false;

    }
}

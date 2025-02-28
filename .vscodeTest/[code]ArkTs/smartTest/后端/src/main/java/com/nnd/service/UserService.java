package com.nnd.service;

import com.nnd.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> queryAllUsers();
    public User queryUserById(int id);
    public boolean addUser(User user);
    public boolean deleteUserById(int id);
    public boolean updateUser(User user);
    public User userLogin(User user);
    public boolean registerUser(User user);

}

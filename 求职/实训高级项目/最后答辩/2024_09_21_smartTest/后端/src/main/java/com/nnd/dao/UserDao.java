package com.nnd.dao;

import com.nnd.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public List<User> queryAllUsers();
    public User queryUserById(int id);
    public int addUser(User user);
    public int deleteUserById(int id);
    public int updateUser(User user);
    public User userLogin(User user);
    public  int registerUser(User user);

}

package com.demo.crm.biz.service.impl;

import com.demo.crm.biz.mapper.UserMapper;
import com.demo.crm.biz.pojo.User;
import com.demo.crm.biz.service.UserService;
import com.demo.crm.vo.PageCondition;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public int count() {
        return userMapper.selectCount(null);
    }

    @Override
    public List<User> findPage(PageCondition pageCondition) {
        return userMapper.findPage(pageCondition);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}

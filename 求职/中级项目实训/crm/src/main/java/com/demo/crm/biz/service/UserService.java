package com.demo.crm.biz.service;

import com.demo.crm.biz.pojo.User;
import com.demo.crm.vo.PageCondition;

import java.util.List;

public interface UserService {
    User login(String username);

    void save(User user);

    int count();

    List<User> findPage(PageCondition pageCondition);

    void updateUser(User user);
}

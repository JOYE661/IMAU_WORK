package com.demo.crm.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.crm.biz.pojo.User;
import com.demo.crm.vo.PageCondition;
import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    // 接口中的每个方法 都要 对应一个 sql 语句
    // 这个 sql语句要写在一个 xml 文件中
    User findByUsername(String username);

    List<User> findPage(PageCondition pageCondition);

    void updateUser(User user);
}

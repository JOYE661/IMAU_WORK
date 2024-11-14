package demo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserMapper extends BaseMapper<User> {

    // 接口中的每个方法 都要 对应一个 sql 语句
    // 这个 sql语句要写在一个 xml 文件中
    User findByUsername(String username);

}

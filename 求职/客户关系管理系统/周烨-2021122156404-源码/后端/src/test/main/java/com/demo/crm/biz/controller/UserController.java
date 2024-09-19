package com.demo.crm.biz.controller;

import com.demo.crm.jwt.JwtUtils;
import com.demo.crm.biz.pojo.User;
import com.demo.crm.biz.service.UserService;
import com.demo.crm.vo.PageCondition;
import com.demo.crm.vo.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    // 注入
    //@Autowired
    @Resource
    private UserService userService;

    // Result ==> json
    @RequestMapping("/login")
    public Result login(@RequestBody User user) {
        User dbUser = userService.login(user.getUsername());
        if (dbUser == null || !dbUser.getPassword().equals(user.getPassword())) {
            return Result.error500("用户名或密码错误");
        }
        // token
        String token = JwtUtils.createToken(dbUser.getId(), dbUser.getUsername(), 2 * 60 * 60);
        return Result.ok().addToken(token);
    }


    // 注册
    // http://localhost:9000/reg?username=aaa&password=111
    @RequestMapping("/user/save")
    public Result reg(@RequestBody User user) throws IOException {
        userService.save(user);
        return Result.ok();
    }

    @RequestMapping("/user/page")
    public Result page(@RequestBody PageCondition pageCondition) {
        int total = userService.count();
        List<User> list = userService.findPage(pageCondition);
        return Result.ok().addTotal(total).addList(list);
    }

    @RequestMapping("/user/update")
    public Result updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return Result.ok();
    }
}

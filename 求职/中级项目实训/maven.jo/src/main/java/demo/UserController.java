package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    // 注入
    //@Autowired
    @Resource
    private UserMapper userMapper;

    @RequestMapping("/get")
    public void get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取输出流 ,自己编码返回内容
        response.getWriter().write("hello world");
    }

    // 接收数据
    // http://localhost:8080/login?username=zhang3&password=123
    // username=zhang3
    // password=123
    @RequestMapping("/login")
    public void login(String username, String password, HttpServletResponse response) throws IOException {
        System.out.println(username);
        System.out.println(password);
        // 获取输出流 ,自己编码返回内容
        response.getWriter().write("hello world");
    }

    // 接收数据
    // http://localhost:8080/login2?username=zhang4&password=1234
    @RequestMapping("/login2")
    public void login2(User user, HttpServletResponse response) throws IOException {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        // 获取输出流 ,自己编码返回内容
        response.getWriter().write("hello world2");
    }

    // 返回数据
    // http://localhost:8080/login3?username=zhang4&password=1234
    @RequestMapping("/login3")
    @ResponseBody
    // String s = login3();
    // response.getWriter().write(s);
    public String login3(User user) throws IOException {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        // 获取输出流 ,自己编码返回内容
        //response.getWriter().write("hello world2");
        return "hello world 3";
    }

    // 返回数据
    // http://localhost:8080/login4?username=zhang4&password=1234
    @RequestMapping("/login4")
    @ResponseBody
    // {"id":null,"username":"zhang4","password":"1234"}
    // json串
    // 当返回值是一个对象的时候, Spring框架内部帮我们把对象转换成JSON格式的字符串
    public User login4(User user) throws IOException {
        // 接收到数据
        // 数据库验证
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return user;
    }

    // 返回数据
    // http://localhost:8080/login5?username=zhang4&password=1234
    @RequestMapping("/login5")
    @ResponseBody
    // {"id":null,"username":"zhang4","password":"1234"}
    // json串
    // 当返回值是一个对象的时候, Spring框架内部帮我们把对象转换成JSON格式的字符串
    public String login5(User user) throws IOException {
        // 接收到数据
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        // 数据库验证
        // select * from user where username = 'aaa'
        User u = userMapper.findByUsername(user.getUsername());
        // 根据此用户名 数据库没有记录
        if (u == null || !u.getPassword().equals(user.getPassword())) {
            // 用户名错误
            return "用户名或者密码错误";
        }
        return "登录成功";
        // [{"id":1,"username":"aaa","password":"111"},{"id":1,"username":"aaa","password":"111"}]
        //List<User> users = userMapper.selectList(null);
    }


    // 注册
    // http://localhost:8080/reg?username=zhang4&password=1234
    @RequestMapping("/reg")
    @ResponseBody
    public String reg(User user) throws IOException {
        // 接收到数据
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        // 存入数据库
        // insert into user (username,password) values (?,?)
        int n = userMapper.insert(user);
        // 根据此用户名 数据库没有记录
        if (n == 1) {
            return "注册成功";
        }
        return "登录失败";
    }
}

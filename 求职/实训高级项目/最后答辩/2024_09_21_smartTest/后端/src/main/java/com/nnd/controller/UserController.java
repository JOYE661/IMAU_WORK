package com.nnd.controller;

import com.nnd.pojo.User;
import com.nnd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> queryAllUsers() {
        return userService.queryAllUsers();
    }

    @GetMapping("/{id}")
    public User queryUserById(@PathVariable("id") int id) {
        return userService.queryUserById(id);
    }

    //@RequestBody表示接受前端传过来的json数据
    @PostMapping
    public boolean addUser( User user) {
        return userService.addUser(user);
    }

    @PutMapping
    public boolean updateUser(User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUserById(@PathVariable("id") int id) {
        return userService.deleteUserById(id);
    }

    @PostMapping("/login")
    public User userLogin(User user) {
        return userService.userLogin(user);

    }

    @PostMapping("/register")
    public boolean registerUser(User user) {
        boolean rows = userService.registerUser(user);
        if (rows) {
            return true;
        }
        return false;

    }
}

package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    //登录功能
    public Map login(User user, HttpSession session){
        user = userService.checkLogin(user);
        session.setAttribute("login_user",user);
        Map map = new HashMap();
        map.put("isOk",true);
        map.put("user",user);
        map.put("msg","登录成功");
        return map;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

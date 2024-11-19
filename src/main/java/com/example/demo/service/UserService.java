package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Project;
import com.example.demo.entity.User;

public interface UserService extends IService<User> {
    User checkLogin(User user);
}

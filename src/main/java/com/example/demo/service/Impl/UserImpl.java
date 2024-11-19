package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Project;
import com.example.demo.entity.User;
import com.example.demo.mapper.ProjectMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.ProjectService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper mapper;
    public User checkLogin(User user){
        User dbUser = mapper.selectUser(user);
        if(dbUser!=null && dbUser.getPassword().equals(user.getPassword())){
            dbUser.setPassword(null);
            return dbUser;
        }else{
            throw new RuntimeException("登陆失败，账号不存在 或密码错误");
        }
    }

    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }
}

package com.sunchg.dbdw.service;

import com.sunchg.dbdw.dao.UserDao;
import com.sunchg.dbdw.entity.User;
import com.sunchg.dbdw.utils.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author SunChonggao
 * @Date 2020-08-30 22:20
 * @Version 1.0
 * @Description：
 */
@Service
public class UserService{
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findUserByName(String username) {
        return userDao.selectByUsername(username);
    }
    /*public Map<String,Object> login(String username, String password, int expiredSeconds) {
        Map<String, Object> map = new HashMap<>();

        //对空值处理
        if (StringUtils.isBlank(username)) {
            map.put("usernameMsg", "用户名不能为空！");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put("passwordMsg", "密码不能为空！");
            return map;
        }

        //验证账户的合法性
        User user = userDao.selectByUsername(username);
        if (user == null) {
            map.put("usernameMsg", "该账号不存在！");
            return map;
        }
        *//*
         验证密码:
         用户输入的为明文密码，数据库中存储的为加密密码，
         所以需要对输入的密码进行加密之后，再与数据库中的密码进行比对
         *//*
        password = AES.getMD5(password + "12345");
        if (!user.getPassword().equals(password)) {
            map.put("passwordMsg", "密码不正确");
            return map;
        }
        //登录成功
        map.put("ticket", UUID.randomUUID().toString().replaceAll("-",""));
        return map;
    }*/

}

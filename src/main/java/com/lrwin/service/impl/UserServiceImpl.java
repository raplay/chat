package com.lrwin.service.impl;

import com.lrwin.dao.UserDao;
import com.lrwin.domain.User;
import com.lrwin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dulei on 1/14/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        User user = new User();
        user.setAge(24);
        user.setUsername("杜雷");
        userDao.save(user);

        return userDao.findAll();
    }
}

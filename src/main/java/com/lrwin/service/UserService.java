package com.lrwin.service;

import com.lrwin.domain.User;

import java.util.List;

/**
 * Created by dulei on 1/14/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:
 */
public interface UserService {
    List<User> findAll();
}

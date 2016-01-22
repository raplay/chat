package com.lrwin.service.impl;

import com.lrwin.dao.AccountDao;
import com.lrwin.domain.Account;
import com.lrwin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
public class AccountServiceImpl implements AccountService {

    private static final String ACCOUNTCACHE="com.lrwin.service.impl.AccountServiceImpl";
    @Autowired
    private AccountDao accountDao;

    @Cacheable(ACCOUNTCACHE)
    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}

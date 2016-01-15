package com.lrwin.rest;

import com.lrwin.domain.Account;
import com.lrwin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dulei on 1/14/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:
 */
@RestController
@RequestMapping("/account")
public class AccoutRest {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Account> getAccount(){

        return accountService.findAll();
    }
}

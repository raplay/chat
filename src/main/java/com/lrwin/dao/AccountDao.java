package com.lrwin.dao;

import com.lrwin.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dulei on 1/14/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:
 */
public interface AccountDao extends JpaRepository<Account, Integer> {

}

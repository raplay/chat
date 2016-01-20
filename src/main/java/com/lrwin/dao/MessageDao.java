package com.lrwin.dao;

import com.lrwin.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dulei on 1/14/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:
 */
public interface MessageDao extends JpaRepository<Message, Integer> {

    List<Message> findByEmaildes(String emaildes);
}

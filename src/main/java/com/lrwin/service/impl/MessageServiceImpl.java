package com.lrwin.service.impl;

import com.lrwin.dao.MessageDao;
import com.lrwin.domain.Message;
import com.lrwin.service.MessageService;
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
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public Message saveMessage(Message message) {
        return messageDao.save(message);
    }

    @Override
    public List<Message> listMessage(String email_des) {
        return messageDao.findByEmaildes(email_des);
    }
}

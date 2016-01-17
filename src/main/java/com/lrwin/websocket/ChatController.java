package com.lrwin.websocket;

import com.lrwin.domain.Account;
import com.lrwin.domain.Message;
import com.lrwin.event.LoginEvent;
import com.lrwin.event.ParticipantRepository;
import com.lrwin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by dulei on 1/15/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:
 */
@Controller
public class ChatController {


    @Autowired
    private AccountService service;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * find all Account
     * @return
     */
    @SubscribeMapping("/accounts")
    public List<Account> getAccounts(){
        List<Account> accounts = service.findAll();

        return accounts;
    }

    /**
     * find all online Account
     * @return
     */
    @SubscribeMapping("/loginUser")
    public List<String> getLoginUser(){
        Map<String, LoginEvent> map = participantRepository.getActiveSessions();
        Iterator<String> iterator = map.keySet().iterator();
        List<String> list = new ArrayList<String>();
        while (iterator.hasNext()){
            list.add(map.get(iterator.next()).getEmail());
        }
        return list;
    }

    /**
     * private chat
     * @param message
     * @param username
     * @param principal
     */
    @MessageMapping("/chat.private.{username}")
    public void filterPrivateMessage(Message message, @DestinationVariable("username") String username, Principal principal) {

        message.setEmail(principal.getName());

        simpMessagingTemplate.convertAndSendToUser(username,"/topic/amq.direct/chat.message",message);
    }



}

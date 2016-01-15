package com.lrwin.websocket;

import com.lrwin.domain.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * Created by dulei on 1/15/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:
 */
@Controller
public class GreetingController {

    @MessageMapping("/greeting")
    public Message handle(Message msg) {
        StringBuffer sb = new StringBuffer(msg.getContent()).append(",hello");
        msg.setContent(sb.toString());
        return msg;
    }
}

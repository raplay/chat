package com.lrwin.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by dulei on 1/15/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:
 */
@Data
public class Message {
    private String content;
    private Date sendTime = new Date();
    private String email;
}

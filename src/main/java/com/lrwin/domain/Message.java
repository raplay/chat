package com.lrwin.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by dulei on 1/15/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:
 */
@Entity
@Data
public class Message {
    @Id
    @GeneratedValue
    private Integer id;

    private String content;
    private Date sendTime = new Date();

    private String emailsrc;

    private String emaildes;

}

package com.lrwin.event;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by dulei on 1/17/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:
 */
@Setter
@Getter
public class LoginEvent {

	private String email;
	private Date time;

	public LoginEvent(String email) {
		this.email = email;
		time = new Date();
	}

}

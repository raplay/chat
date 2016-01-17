package com.lrwin.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
@AllArgsConstructor
public class LogoutEvent {
	private String email;
}

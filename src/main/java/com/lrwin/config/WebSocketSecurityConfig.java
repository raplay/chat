package com.lrwin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
/**
 * Created by dulei on 1/16/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:
 */
@Configuration
public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

	@Override
	protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
		//		messages
//				.nullDestMatcher().authenticated() 1
//				.simpSubscribeDestMatchers("/user/queue/errors").permitAll() 2
//				.simpDestMatchers("/app/**").hasRole("USER") 3
//				.simpSubscribeDestMatchers("/user/**", "/topic/friends/*").hasRole("USER") 4
//				.simpTypeMatchers(MESSAGE, SUBSCRIBE).denyAll() 5
//				.anyMessage().denyAll(); 6
//
//		This will ensure that:
//
//		1
//		Any message without a destination (i.e. anything other that Message type of MESSAGE or SUBSCRIBE) will require the user to be authenticated
//		2
//		Anyone can subscribe to /user/queue/errors
//		3
//		Any message that has a destination starting with "/app/" will be require the user to have the role ROLE_USER
//		4
//		Any message that starts with "/user/" or "/topic/friends/" that is of type SUBSCRIBE will require ROLE_USER
//		5
//		Any other message of type MESSAGE or SUBSCRIBE is rejected. Due to 6 we do not need this step, but it illustrates how one can match on specific message types.
//		6
//		Any other Message is rejected. This is a good idea to ensure that you do not miss any messages.
	}

	@Override
	protected boolean sameOriginDisabled() {
		//disable CSRF for websockets for now...
		return true;
	}
}
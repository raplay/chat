package com.lrwin.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by dulei on 1/15/16.
 * Email:codingbaby@gmail.com
 * Site:http:lrwin.leanote.com
 * Github:https://github.com/raplay
 * Author:Lrwin
 * Description:
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

//    private SimpMessagingTemplate messagingTemplate;
    //this.messagingTemplate.convertAndSendToUser(
//    trade.getUserName(), "/queue/position-updates", trade.getResult());
    //-> user/trad.geUserName()/queue/position-updates



//    @MessageExceptionHandler
//    @SendToUser(destinations="/queue/errors", broadcast=false)
//    public ApplicationError handleException(MyBusinessException exception) {
//        // ...
//        return appError;
//    }



    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes("/app");
        config.enableSimpleBroker("/topic", "/user");
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.setInterceptors(presenceChannelInterceptor());
    }

    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        registration.taskExecutor().corePoolSize(8);
        registration.setInterceptors(presenceChannelInterceptor());
    }

    @Bean
    public PresenceChannelInterceptor presenceChannelInterceptor() {
        return new PresenceChannelInterceptor();
    }

    private class PresenceChannelInterceptor extends ChannelInterceptorAdapter {
        private final Log logger = LogFactory.getLog(PresenceChannelInterceptor.class);
        @Override
        public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
            StompHeaderAccessor sha = StompHeaderAccessor.wrap(message);
            // ignore non-STOMP messages like heartbeat messages
            if(sha.getCommand() == null) {
                return;
            }
//            sha.getUser().getName(); so.. Principal is important
            logger.debug("username: " + sha.getUser().getName());
            String sessionId = sha.getSessionId();
            switch(sha.getCommand()) {
                case CONNECT:
                    logger.debug("STOMP Connect [sessionId: " + sessionId + "]");
                    break;
                case CONNECTED:
                    logger.debug("STOMP Connected [sessionId: " + sessionId + "]");
                    break;
                case DISCONNECT:
                    logger.debug("STOMP Disconnect [sessionId: " + sessionId + "]");
                    break;
                default:
                    break;

            }
        }
    }
}

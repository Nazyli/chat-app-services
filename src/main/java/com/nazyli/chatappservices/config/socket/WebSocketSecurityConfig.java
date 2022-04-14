package com.nazyli.chatappservices.config.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

@Configuration
public class WebSocketSecurityConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {
    @Override
    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
//        messages
//                // message types other than MESSAGE and SUBSCRIBE
//                .simpTypeMatchers(SimpMessageType.CONNECT, SimpMessageType.HEARTBEAT, SimpMessageType.UNSUBSCRIBE, SimpMessageType.DISCONNECT).permitAll()
//                // matches any destination that starts with /rooms/
//                .simpDestMatchers("/user/**").authenticated()
//                .simpDestMatchers("/app/**").authenticated()
//                // (i.e. cannot send messages directly to /topic/, /queue/)
//                // (i.e. cannot subscribe to /topic/messages/* to get messages sent to
//                // /topic/messages-user<id>)
//                .simpTypeMatchers(SimpMessageType.MESSAGE, SimpMessageType.SUBSCRIBE).denyAll()
//                // catch all
//                .anyMessage().denyAll();

//        messages
//                .simpDestMatchers("/user/**").authenticated()
//                .simpDestMatchers("/app/**").authenticated()
//                .simpTypeMatchers(SimpMessageType.CONNECT, SimpMessageType.HEARTBEAT, SimpMessageType.UNSUBSCRIBE, SimpMessageType.DISCONNECT).permitAll()
//                .simpTypeMatchers(SimpMessageType.MESSAGE, SimpMessageType.SUBSCRIBE).denyAll()
//                .anyMessage().denyAll();
//                .simpDestMatchers("/app/**").authenticated()
//                .simpSubscribeDestMatchers("/user/**").authenticated();

//        messages.simpSubscribeDestMatchers("/user/**").permitAll()
//                .simpDestMatchers("/app/**").authenticated();

        messages.anyMessage().authenticated();

    }

    // TODO: For test purpose (and simplicity) i disabled CSRF, but you should re-enable this and provide a CRSF endpoint.
    @Override
    protected boolean sameOriginDisabled() {
        //disable CSRF for websockets for now...
        return true;
    }
}

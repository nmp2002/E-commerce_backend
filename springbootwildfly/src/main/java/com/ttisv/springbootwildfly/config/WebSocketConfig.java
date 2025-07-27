package com.ttisv.springbootwildfly.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // Kênh gửi thông báo
        config.setApplicationDestinationPrefixes("/app"); // Tiền tố của các API WebSocket
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket-notifications") // Endpoint WebSocket
                .setAllowedOrigins("http://localhost:4200") // Cho phép tất cả domain
                .withSockJS(); // Hỗ trợ SockJS cho các trình duyệt cũ
    }
}

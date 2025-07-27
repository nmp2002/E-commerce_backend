package com.ttisv.springbootwildfly.controllers;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificationController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    /**
     * Phát thông báo đến tất cả các client qua WebSocket
     *
     * @param message Nội dung thông báo
     */
    public void sendNotification(String message) {
        System.out.println("Sending notification: " + message);
        messagingTemplate.convertAndSend("/topic/notifications", message);
    }
}

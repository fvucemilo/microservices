package com.fvucemilo.notification.controller;

import com.fvucemilo.clients.notification.NotificationRequest;
import com.fvucemilo.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    public void sendNotification(NotificationRequest notificationRequest) {
        notificationService.send(notificationRequest);
    }
}

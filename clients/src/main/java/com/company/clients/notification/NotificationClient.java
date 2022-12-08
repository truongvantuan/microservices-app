package com.company.clients.notification;

import com.company.clients.notification.model.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("notification")
public interface NotificationClient {

    @GetMapping("/api/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);
}

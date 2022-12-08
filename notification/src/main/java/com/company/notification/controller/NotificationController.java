package com.company.notification.controller;

import com.company.notification.model.Notification;
import com.company.notification.model.NotificationResponse;
import com.company.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/api/v1/notification")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/{customerId}")
    public void notification(@PathVariable("customerId") Long customerId) {
        NotificationResponse response = NotificationResponse.builder()
                .customerId(customerId)
                .build();
        log.info(response.getFullMessage());

        Notification notification = Notification.builder()
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .build();

        notificationService.notification(notification);
    }
}

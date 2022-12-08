package com.company.notification.service;

import com.company.notification.model.Notification;
import com.company.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void notification(Notification notification) {
        notificationRepository.save(notification);
    }
}

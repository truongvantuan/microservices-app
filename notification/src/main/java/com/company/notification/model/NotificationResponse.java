package com.company.notification.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotificationResponse {
    private Long customerId;
    private LocalDateTime createdAt;

    public String getFullMessage() {
        return String.format("Welcome customerID: %s to Microservices App", customerId);
    }
}

package com.company.clients.notification.model;

public record NotificationRequest(Long toCustomerId, String toCustomerEmail, String message) {
}

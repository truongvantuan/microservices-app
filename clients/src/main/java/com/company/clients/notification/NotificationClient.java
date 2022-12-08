package com.company.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("notification")
public interface NotificationClient {

    @GetMapping("/api/v1/notification/{customerId}")
    void notification(@PathVariable("customerId") Long customerId);
}

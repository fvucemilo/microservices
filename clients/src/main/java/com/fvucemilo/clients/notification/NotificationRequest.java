package com.fvucemilo.clients.notification;

import lombok.Builder;

@Builder
public record NotificationRequest(
        Long toCustomerId,
        String toCustomerName,
        String message
) {
}

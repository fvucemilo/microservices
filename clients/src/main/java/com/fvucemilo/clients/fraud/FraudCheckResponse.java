package com.fvucemilo.clients.fraud;

import lombok.Builder;

@Builder
public record FraudCheckResponse(Boolean isFraudster) {
}

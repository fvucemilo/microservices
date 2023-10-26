package com.fvucemilo.fraud.service;

import com.fvucemilo.fraud.dao.FraudRepository;
import com.fvucemilo.fraud.model.Fraud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudService {

    private final FraudRepository fraudRepository;

    public boolean isFraudulentCustomer(Long customerId) {
        fraudRepository.save(
                Fraud.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}

package com.fvucemilo.fraud.service.impl;

import com.fvucemilo.fraud.dao.FraudRepository;
import com.fvucemilo.fraud.model.Fraud;
import com.fvucemilo.fraud.service.FraudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudServiceImpl implements FraudService {

    private final FraudRepository fraudRepository;

    @Override
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

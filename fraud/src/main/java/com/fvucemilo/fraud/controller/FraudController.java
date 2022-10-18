package com.fvucemilo.fraud.controller;

import com.fvucemilo.fraud.dto.FraudCheckResponseDto;
import com.fvucemilo.fraud.service.FraudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check/")
@RequiredArgsConstructor
public class FraudController {

    private final FraudService fraudService;

    @GetMapping(path = "{customerId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public FraudCheckResponseDto isFraudster(
            @PathVariable("customerId") Long customerId) {
        boolean isFraudulentCustomer = fraudService
                .isFraudulentCustomer(customerId);
        log.info("Fraud check request for customer {}", customerId);

        return new FraudCheckResponseDto(isFraudulentCustomer);
    }
}

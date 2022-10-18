package com.fvucemilo.customer.controller;

import com.fvucemilo.customer.dto.CustomerRegistrationRequestDto;
import com.fvucemilo.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerCustomer(@RequestBody CustomerRegistrationRequestDto customerRegistrationRequestDto) {
        log.info("New customer registration {}", customerRegistrationRequestDto);
        customerService.registerCustomer(customerRegistrationRequestDto);
    }
}

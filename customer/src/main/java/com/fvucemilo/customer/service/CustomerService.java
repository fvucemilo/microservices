package com.fvucemilo.customer.service;

import com.fvucemilo.customer.dto.CustomerRegistrationRequestDto;

public interface CustomerService {

    void registerCustomer(CustomerRegistrationRequestDto customerRegistrationRequestDto);
}

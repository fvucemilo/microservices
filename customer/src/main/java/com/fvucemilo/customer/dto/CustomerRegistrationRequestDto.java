package com.fvucemilo.customer.dto;

public record CustomerRegistrationRequestDto(
        String firstName,
        String lastName,
        String email) {
}

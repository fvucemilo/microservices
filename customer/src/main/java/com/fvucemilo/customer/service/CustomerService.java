package com.fvucemilo.customer.service;

import com.fvucemilo.amqp.config.RabbitMQMessageProducer;
import com.fvucemilo.clients.fraud.FraudCheckResponse;
import com.fvucemilo.clients.fraud.FraudClient;
import com.fvucemilo.clients.notification.NotificationClient;
import com.fvucemilo.clients.notification.NotificationRequest;
import com.fvucemilo.customer.dao.CustomerRepository;
import com.fvucemilo.customer.dto.CustomerRegistrationRequestDto;
import com.fvucemilo.customer.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void registerCustomer(CustomerRegistrationRequestDto request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);
        // todo: check if fraudster
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // todo: send notification
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Amigoscode...",
                        customer.getFirstName())
        );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}

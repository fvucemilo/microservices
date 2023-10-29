package com.fvucemilo.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.fvucemilo.clients"
)
@SpringBootApplication(
        scanBasePackages = {
                "com.fvucemilo.customer",
                "com.fvucemilo.amqp",
        }
)public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}

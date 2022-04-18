package com.udemy.rabbitmq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class RabbitmqConsumerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumerApplication.class, args);
    }
    
}

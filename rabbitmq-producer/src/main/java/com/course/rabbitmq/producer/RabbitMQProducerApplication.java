package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.producer.HelloRabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitMQProducerApplication implements CommandLineRunner {
//    private final HelloRabbitProducer helloRabbitProducer;
    
//    public RabbitMQProducerApplication(HelloRabbitProducer helloRabbitProducer) {
//        this.helloRabbitProducer = helloRabbitProducer;
//    }
    
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQProducerApplication.class, args);
    }
    
    @Override
    public void run(String... args) {
    // helloRabbitProducer.sendHello("Ifeanyichukwu " + Math.random());
    
    }
}

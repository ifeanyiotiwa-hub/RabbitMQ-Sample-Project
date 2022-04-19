package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.entity.Picture;
import com.course.rabbitmq.producer.producer.EmployeeJsonProducer;
import com.course.rabbitmq.producer.producer.HelloRabbitProducer;
import com.course.rabbitmq.producer.producer.PictureProducer;
import com.course.rabbitmq.producer.producer.PictureProducerTopicExchange;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
//@EnableScheduling
public class RabbitMQProducerApplication implements CommandLineRunner {
//    @Autowired
//    EmployeeJsonProducer employeeJsonProducer;
    
    @Autowired
    private PictureProducerTopicExchange pictureProducer;
    private final List<String> SOURCES = List.of("mobile", "web");
    
    private  final  List<String> TYPES = List.of("svg", "jpg", "png");
    
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQProducerApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws JsonProcessingException {
        for (int i = 0; i < 10; i++) {
            Picture picture = new Picture();
            picture.setName("Picture " + i);
            picture.setSize(ThreadLocalRandom.current().nextLong(1, 100000));
            picture.setSource(SOURCES.get(i % SOURCES.size()));
            picture.setType(TYPES.get(i % TYPES.size()));
            System.err.println(picture);
            pictureProducer.sendMessage(picture);
        }
    }
}

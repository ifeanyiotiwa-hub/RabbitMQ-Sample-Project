package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.entity.Furniture;
import com.course.rabbitmq.producer.entity.Picture;
import com.course.rabbitmq.producer.producer.*;
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
    
    @Autowired
    private FurnitureProducer producer;
    
    private final List<String> COLORS = List.of("white", "red", "green");
    
    private final List<String> MATERIALS = List.of("wood", "plastic", "steel");
    
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQProducerApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws JsonProcessingException {
        for (int i = 0; i < 10; i++) {
            Furniture furniture = new Furniture();
            furniture.setName("Furniture " + i);
            furniture.setColor(COLORS.get(i % COLORS.size()));
            furniture.setMaterial(MATERIALS.get(i % MATERIALS.size()));
            furniture.setPrice(i * ThreadLocalRandom.current()
                    .nextInt(1000, 2001));
            
            producer.sendMessage(furniture);
    
            System.err.println("sent : " + furniture);
            
        }
    }
}

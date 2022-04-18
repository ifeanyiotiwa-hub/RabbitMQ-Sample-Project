package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.producer.EmployeeJsonProducer;
import com.course.rabbitmq.producer.producer.HelloRabbitProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

@SpringBootApplication
//@EnableScheduling
public class RabbitMQProducerApplication implements CommandLineRunner {
    @Autowired
    EmployeeJsonProducer employeeJsonProducer;
    
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQProducerApplication.class, args);
    }
    
    @Override
    public void run(String... args) {
        for (int i = 0; i < 5; i++) {
            Employee employee = new Employee("emp" + i
                    , "Employee " + i
                    , LocalDate.now()
                                        .plusYears(i));
            try {
                employeeJsonProducer.sendMessage(employee);
            } catch (JsonProcessingException e) {
                e.getLocalizedMessage();
            }
        }
    }
}

package com.udemy.rabbitmq.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.rabbitmq.consumer.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeJsonConsumer {
    
    @Autowired
    private ObjectMapper objectMapper;
    
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeJsonConsumer.class);
    
    
    
    @RabbitListener(queues = "course.employee")
    public void readMessage(String message) throws JsonProcessingException {
        Employee employee = objectMapper.readValue(message, Employee.class);
        LOG.info("Consuming {}", employee);
    }
    
    
}

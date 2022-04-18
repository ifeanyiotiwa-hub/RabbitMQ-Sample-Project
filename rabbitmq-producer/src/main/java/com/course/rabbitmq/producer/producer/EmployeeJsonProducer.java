package com.course.rabbitmq.producer.producer;


import com.course.rabbitmq.producer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonProducer {
    
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    public void sendMessage(Employee employee) throws JsonProcessingException {
        //convert string to json
        String json = objectMapper.writeValueAsString(employee);
        rabbitTemplate.convertAndSend("course.employee", json);
    }
}

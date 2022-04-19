package com.course.rabbitmq.producer.producer;

import com.course.rabbitmq.producer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureProducerTopicExchange {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    public void sendMessage(Picture picture) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(picture);
        StringBuilder sb = new StringBuilder();
        
        sb.append(picture.getSource());
        sb.append(".");
        
        if (picture.getSize() > 4000) {
            sb.append("large");
        } else {
            sb.append("small");
        }
        sb.append(".");
        
        sb.append(picture.getType());
        
        rabbitTemplate.convertAndSend("x.picture2",sb.toString(), json);
    }
}

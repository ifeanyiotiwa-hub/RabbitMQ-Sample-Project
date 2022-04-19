package com.udemy.rabbitmq.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.rabbitmq.consumer.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//@Service
public class PictureFilterConsumer {
        private static final Logger LOG =
                LoggerFactory.getLogger(com.udemy.rabbitmq.consumer.consumer.PictureFilterConsumer.class);
        
//        @Autowired
        private ObjectMapper objectMapper;
        
        
        
        @RabbitListener(queues = "q.picture.filter")
        public void listen(String message) throws JsonProcessingException {
            Picture picture = objectMapper.readValue(message, Picture.class);
            
            LOG.info("on filter queue {}", picture);
        }
        
}

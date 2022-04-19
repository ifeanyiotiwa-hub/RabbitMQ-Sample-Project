package com.udemy.rabbitmq.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.udemy.rabbitmq.consumer.entity.Picture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;

//@Service
public class MyPictureImageConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(MyPictureImageConsumer.class);
    
//    @Autowired
    private ObjectMapper objectMapper;
    
    
    
    @RabbitListener(queues = "q.mypicture.image")
    public void listen(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        Picture picture = objectMapper.readValue(message, Picture.class);
        
        if (picture.getSize() > 9000) {
//            throw new AmqpRejectAndDontRequeueException(picture + " Too large");
            
            channel.basicReject(tag,false);
            return;
        }
        
        LOG.info("on Image queue {}", picture);
        channel.basicAck(tag,false);
    }
    
}

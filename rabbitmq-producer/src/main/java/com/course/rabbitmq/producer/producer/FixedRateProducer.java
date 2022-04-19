package com.course.rabbitmq.producer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class FixedRateProducer {
    private final RabbitTemplate rabbitTemplate;
    
    private static final Logger LOG = LoggerFactory.getLogger(FixedRateProducer.class);
    
    private int i = 0;
    
    public FixedRateProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    
    @Scheduled(fixedRate = 500)
    public  void sendMessage() {
        i++;
//        LOG.info("i is " + i);
        rabbitTemplate.convertAndSend("course.fixedrate", "Fixed rate " + i);
    }
}

package com.learn.lspring;

import com.learn.logg.Logl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class KafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Logl logl;
    @KafkaListener(topics = {"my-topic"})
    public void receive(String message){
        logl.doSometing();
        log.info(message);
        System.out.println("app_log1111--消费消息:" + message);
    }

}

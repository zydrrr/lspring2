package com.learn.lspring;

import com.learn.configur.Config;
import com.learn.logg.Logl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class KafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private Config config;

    @Autowired
    public KafkaConsumer(Config config){
        this.config = config;
    }

    @Autowired
    private Logl logl;
    @KafkaListener(topics = {"my-topic"})
    public void receive(String message){
        logl.doSometing();
        log.info(message);
        System.out.println("app_log1111--消费消息:" + message);
    }

    public void doSometing(){

        logl.doSometing();

        String st=config.getString2("com.test.string");
        System.out.println("string:"+st);

        int queue=config.getQueue_capacity();
        System.out.println("que int:"+queue);

        // 通过static方法直接获取 不用建立对象
        String st2=Config.getString("com.test.string");
        System.out.println("string2:"+st2);
    }

}

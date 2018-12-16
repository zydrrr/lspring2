package com.learn;

import com.learn.lspring.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class LspringApplication implements CommandLineRunner {
    public static void main(String[] args){
        SpringApplication.run(LspringApplication.class, args);
    }

    @Autowired
    KafkaConsumer kafkaConsumer;
    public void run(String ... args){
        System.out.println("kafcom==========");
        kafkaConsumer.doSometing();
    }
}


package com.learn.lspring;

import com.learn.configur.Config;
import com.learn.dao.Mong;
import com.learn.dao.UserEntity;

import com.learn.logg.Logl;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class KafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private Config config;
    private Logl logl;

    @Autowired
    Mong mong;

    @Autowired
    public KafkaConsumer(Config config,Logl logl){
        this.config = config;
        this.logl = logl;
    }


//    @KafkaListener(topics = {"my-topic"})
//    public void receive(String message){
//        logl.doSometing();
//        log.info(message);
//        System.out.println("app_log1111--消费消息:" + message);
//    }

    public void doSometing(){

        logl.doSometing();

        String st=config.getString2("com.test.string");
        System.out.println("string:"+st);

        int queue=config.getQueue_capacity();
        System.out.println("que int:"+queue);

        // 通过static方法直接获取 不用建立对象
        String st2=Config.getString("com.test.string");
        System.out.println("string2:"+st2);

        UserEntity user = new UserEntity();
        user.setPassWord("pass");
        user.setUserName("hh");
        UserEntity.UserEntity2 subuser =new UserEntity.UserEntity2();
        subuser.setSubName("subbn");
        subuser.setSubNumber(22L);
        user.setSubEntity(subuser);
        System.out.println(user.toString());
        mong.insetUser(user);

        UserEntity uu2=new UserEntity();
        uu2.setUserName("hh");
        uu2.setPassWord("updatatee");
        mong.updateUser(uu2);
        System.out.println(mong.findUserById(new ObjectId("5c13494e45aa2db7083d7b18")).toString());
        System.out.println(mong.findUserByName("hh").toString());
    }

}

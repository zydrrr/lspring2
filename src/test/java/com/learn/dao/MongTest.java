package com.learn.dao;


import com.mongodb.Mongo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;


@SpringBootTest
public class MongTest {

    //使用测试时@Autowired注解不能注入对象。。。重新在setUp()函数中生成对象。
    private Mong mong;
    private  MongoTemplate mongoTemplate;

    @Before
    public void setUp() throws Exception {
        try {
            UserCredentials uc = new UserCredentials("****","*****");
            Mongo mo=new Mongo("*",0);
            mongoTemplate =new MongoTemplate(mo, "*", uc);
            mong = new Mong();
        } catch (Exception e){}
        mong.setMongoTemplate(mongoTemplate);
    }

    @Test
    public void insetUser() {
        UserEntity user = new UserEntity();
        user.setUserName("hh");
        user.setPassWord("890");
        System.out.println(user);
        System.out.println(mong.getMongoTemplate());
        mong.insetUser(user);
    }
    @Test
    public void findUserByName() {
        UserEntity user = new UserEntity();
        user.setUserName("hh");
        user.setPassWord("890");
        System.out.println(user);
        System.out.println(mong.getMongoTemplate());
        mong.insetUser(user);
        mong.findUserByName("hh");
    }

    @Test
    public void updateUser() {
        UserEntity user = new UserEntity();
        user.setUserName("hh");
        user.setPassWord("9999");
        mong.updateUser(user);
    }

    @Test
    public void deleteUserByName() {
        mong.deleteUserByName("hh");
    }


}
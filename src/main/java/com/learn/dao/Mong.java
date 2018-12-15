package com.learn.dao;

import com.learn.configur.Config;
import com.mongodb.MongoClientURI;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;



@Component
public class Mong {


    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    /*
    *   要去除mongodb 中的_class 默认字段 需要设置DefaultMongoTypeMapper(null) 所以需要自己构建MongoTemplate
    *   使用@Bean注解 当使用@Autowired自动装配MongoTemplate时，将优先使用该MongoDbFactory bean。
    *
    * */
        @Bean
        public MongoDbFactory mongoDbFactory () throws Exception {
        MongoClientURI mongoClientURI = new MongoClientURI(Config.getString("spring.data.mongodb.uri"));
        return new SimpleMongoDbFactory(mongoClientURI);
        }

        @Bean
        public MongoTemplate mongoTemplate () throws Exception {
        //remove _class
        MappingMongoConverter converter =
                new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);
        return mongoTemplate;
        }


    @Autowired
    private  MongoTemplate mongoTemplate;

    public UserEntity findUserByName(String name){
        Query query=new Query(Criteria.where("userName").is(name));
        UserEntity user= mongoTemplate.findOne(query,UserEntity.class);
        return user;
    }

    public UserEntity findUserById(ObjectId id){
        Query query=new Query(Criteria.where("id").is(id));
        UserEntity user= mongoTemplate.findOne(query,UserEntity.class);
        return user;
    }

    public void updateUser(UserEntity user){
        Query query=new Query(Criteria.where("userName").is(user.getUserName()));
        Update update= new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,UserEntity.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    public void insetUser(UserEntity user){
        mongoTemplate.insert(user);
    }

    public void deleteUserByName(String name){
        Query query=new Query(Criteria.where("userName").is(name));
        mongoTemplate.remove(query,UserEntity.class);
    }

}

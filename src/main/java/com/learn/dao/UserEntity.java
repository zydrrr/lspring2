package com.learn.dao;

import com.learn.util.Jsonle;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


import java.io.Serializable;

@Data
public class UserEntity implements Serializable {
    @Id
    private ObjectId id;
    private String userName;
    private String passWord;
    private UserEntity2 subEntity;

    //可以重写toString()输出想要的结果
    @Override
    public String toString(){
//        return String.format("{\"id\":%s,\"userName\":\"%s\",\"passWord\":\"%s\",\"subEntity\":{\"subNumber\":%d,\"subName\":\"%s\"}}"
//                ,id,userName,passWord,subEntity.subNumber,subEntity.subName);
        return Jsonle.toJson(this);
    }

    @Data
    public static class UserEntity2 {
        private Long subNumber;
        private String subName;
    }
}



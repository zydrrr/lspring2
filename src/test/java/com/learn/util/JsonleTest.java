package com.learn.util;

import com.alibaba.fastjson.JSONObject;
import com.learn.dao.UserEntity;
import org.bson.types.ObjectId;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonleTest {

    @Test
    public void toJson() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassWord("passw");
        userEntity.setUserName("testname");
        UserEntity.UserEntity2 userEntity2=new UserEntity.UserEntity2();
        userEntity2.setSubName("subname");
        userEntity2.setSubNumber(11l);
        userEntity.setSubEntity(userEntity2);
        System.out.println(Jsonle.toJson(userEntity));
    }

    @Test
    public void toParse() {
        String json="{\"id\":null,\"passWord\":\"passw\",\"subEntity\":{\"subName\":\"subname\",\"subNumber\":11},\"userName\":\"testname\"}";
        JSONObject jo=Jsonle.toParse(json);
        assertEquals("passw",jo.getString("passWord"));
        assertEquals("subname",jo.getJSONObject("subEntity").getString("subName"));
        assertEquals(null,jo.getJSONObject("id"));
    }
}
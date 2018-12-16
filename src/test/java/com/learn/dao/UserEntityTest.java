package com.learn.dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserEntityTest {

    @Test
    public void String() {
        UserEntity user = new UserEntity();
        user.setPassWord("12332");
        UserEntity.UserEntity2 u2 = new UserEntity.UserEntity2();
        u2.setSubName("2name");
        user.setSubEntity(u2);
        user.toString();
        System.out.println(user.toString());
    }
}
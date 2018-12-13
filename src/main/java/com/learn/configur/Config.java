package com.learn.configur;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class Config {

    private final static Properties properties;

    // 方式1 直接通过注解配置
    @Value("${com.test.int}")
    private int queue_capacity;

    // 静态初始化
    static {
        InputStream in = Config.class.getClassLoader().getResourceAsStream("application.properties");
        properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            System.out.println("init config error"+ e);
        }
    }

    /*
    *   static 不用创建对象就能调用
    * */
    public static String getString(String conf)
    {
        return properties.getProperty(conf);
    }

    public String getString2(String conf)
    {
        return properties.getProperty(conf);
    }

    public int getQueue_capacity() {
        return queue_capacity;
    }

}

package com.learn.configur;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigTest {

    private Config config;
    @Before
    public void setUp() throws Exception {
        try {
            config = new Config();
        }catch (Exception e){
            System.out.println("exception:"+e);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getString() {
        String str=Config.getString("com.test.string");
        assertEquals("1etwt",str);
    }

    @Test
    public void getString2() {
        String str = config.getString2("com.test.string");
        assertEquals("1etwt",str);

    }

}
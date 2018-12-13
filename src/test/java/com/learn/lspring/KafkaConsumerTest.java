package com.learn.lspring;

import com.learn.logg.Logl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import static org.junit.Assert.*;

public class KafkaConsumerTest {

    private Logl logl;
    @Test
    public void doSometing1() {
        logl.doNothing();
    }

    @Test
    public void receive() {
    }

    @Test
    public void doSometing() {
    }

    @Before
    public void setUp() throws Exception {
        try {
            logl = new Logl();
        }catch (Exception e)
        {
            System.out.println("exception :"+e);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void raeceive1() {
    }


}
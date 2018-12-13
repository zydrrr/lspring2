package com.learn.logg;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Logl {
    private static final Logger log = LoggerFactory.getLogger(Logl.class);
    public Logl(){
    }

    public void doSometing(){
        System.out.println("logl doing sm");
        log.info("infooooooooo");
        log.debug("debugggggggg");
        log.error("errrrrrrrrrr");
    }

    public void doNothing(){
        System.out.println("logl do nothing!");
    }
}

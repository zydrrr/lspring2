package com.learn.logg;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Logl {
    private final Logger log = Logger.getLogger(this.getClass());
    public Logl(){
        log.info("infooooooooo");
        log.debug("debugggggggg");
        log.error("errrrrrrrrrr");
    }

    public void doSometing(){
        System.out.println("logl doing sm");
    }
}

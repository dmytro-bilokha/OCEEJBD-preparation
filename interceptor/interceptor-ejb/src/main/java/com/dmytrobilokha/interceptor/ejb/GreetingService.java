package com.dmytrobilokha.interceptor.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class GreetingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingService.class);

    public String createGreeting() {
        LOGGER.info("GreetingService createGreeting called");
        return "Hello, Glory Enterprise World!!!";
    }

}

package com.dmytrobilokha.interceptor.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
public class GreetingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingService.class);

    @Interceptors(GreetingServiceInterceptor.class)
    public String createGreeting() {
        LOGGER.info("GreetingService createGreeting called");
        return "Hello, Glory Enterprise World!!!";
    }

}

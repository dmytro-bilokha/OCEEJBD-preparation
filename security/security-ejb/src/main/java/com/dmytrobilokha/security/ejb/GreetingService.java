package com.dmytrobilokha.security.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

@Stateless
@DeclareRoles({"qa_users"})
public class GreetingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingService.class);

    @PermitAll
    public String createCommonGreeting() {
        LOGGER.info("GreetingService createCommonGreeting called");
        return "Hello, All!";
    }

    @RolesAllowed({"qa_users"})
    public String createGreeting() {
        LOGGER.info("GreetingService createGreeting called");
        return "Hello, PRIVILEGED!";
    }

}

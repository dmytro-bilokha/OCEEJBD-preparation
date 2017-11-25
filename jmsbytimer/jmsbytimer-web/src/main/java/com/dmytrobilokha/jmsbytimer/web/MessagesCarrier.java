package com.dmytrobilokha.jmsbytimer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("messagesCarrier")
public class MessagesCarrier {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagesCarrier.class);

    private String message;

    @PostConstruct
    public void init() {
        LOGGER.info("MessagesCarrier initializing");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

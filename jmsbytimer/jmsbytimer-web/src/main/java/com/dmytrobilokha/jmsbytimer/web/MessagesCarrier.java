package com.dmytrobilokha.jmsbytimer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

@RequestScoped
@Named
public class MessagesCarrier {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagesCarrier.class);

    private String title = "Default Title";
    private List<String> messages = Collections.emptyList();

    @PostConstruct
    public void init() {
        LOGGER.info("MessagesCarrier initializing");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

}

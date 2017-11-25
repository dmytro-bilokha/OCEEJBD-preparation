package com.dmytrobilokha.jmsbytimer.ejb;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.time.LocalDateTime;

@Singleton
@Startup
public class MessageSource {

    private int counter = 0;

    @Inject
    private MessageStorage messageStorage;

    @Schedule(minute = "*/1", hour = "*")
    void sendMessage() {
        messageStorage.addMessage(LocalDateTime.now() + ": message " + counter++);
    }

}

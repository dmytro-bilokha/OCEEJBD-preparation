package com.dmytrobilokha.jmsbytimer.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Singleton
public class MessageStorage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageStorage.class);
    private static final int MAX_MESSAGES = 1000;

    private final Queue<String> messages = new LinkedList<>();

    @Lock(LockType.WRITE)
    public void addMessage(String message) {
        LOGGER.info("addMessage called");
        while (messages.size() >= MAX_MESSAGES) {
            messages.poll();
        }
        messages.offer(message);
    }

    @Lock(LockType.READ)
    public List<String> getMessages() {
        LOGGER.info("getMessages called");
        return new ArrayList<>(messages);
    }

}

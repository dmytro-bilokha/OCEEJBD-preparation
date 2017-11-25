package com.dmytrobilokha.jmsbytimer.ejb;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Message;
import java.time.LocalDateTime;

@Singleton
public class MessageSource {

    private int counter = 0;

    @Inject
    @JMSConnectionFactory("jms/jmsForTimerConnectionFactory")
    private JMSContext jmsContext;

    @Resource(name = "jms/timeMessagesQueue")
    private Destination destination;

    @Schedule(minute = "*/1", hour = "*")
    void sendMessage() {
        Message message = jmsContext.createTextMessage(LocalDateTime.now() + ": message " + counter++);
        jmsContext.createProducer().send(destination, message);
    }

}

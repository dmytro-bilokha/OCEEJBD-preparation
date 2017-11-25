package com.dmytrobilokha.jmsbytimer.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
        , @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/timeMessagesQueue")
})
public class MessageRecepient implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageRecepient.class);

    @Inject
    private MessageStorage messageStorage;

    @Override
    public void onMessage(Message message) {
        if (!(message instanceof TextMessage)) {
            LOGGER.error("Got message {} which is not instance of TextMessage", message);
            return;
        }
        TextMessage textMessage = (TextMessage) message;
        try {
            messageStorage.addMessage(textMessage.getText());
        } catch (JMSException e) {
            LOGGER.error("Got exception", e);
        }
    }

}

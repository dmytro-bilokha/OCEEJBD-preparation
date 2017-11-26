package com.dmytrobilokha.jmsbytimer.web;

import com.dmytrobilokha.jmsbytimer.ejb.MessageStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/")
public class InfoServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoServlet.class);

    private static final AtomicInteger REQUEST_COUNTER = new AtomicInteger(0);

    @Inject
    private MessageStorage messageStorage;
    @Inject
    private MessagesCarrier messagesCarrier;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("InfoServlet doGet called");
        messagesCarrier.setTitle("Request " + REQUEST_COUNTER.incrementAndGet());
        messagesCarrier.setMessages(messageStorage.getMessages());
        NavigablePage.INFO.forwardTo(req, resp);
    }

}

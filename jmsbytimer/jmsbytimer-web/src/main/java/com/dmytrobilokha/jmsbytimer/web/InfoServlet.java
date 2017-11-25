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

@WebServlet(urlPatterns = "/")
public class InfoServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoServlet.class);

    @Inject
    private MessageStorage messageStorage;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("InfoServlet doGet called");
        req.setAttribute("messages", messageStorage.getMessages());
        req.getRequestDispatcher("/WEB-INF/jsp/info.jspx").forward(req, resp);
    }

}

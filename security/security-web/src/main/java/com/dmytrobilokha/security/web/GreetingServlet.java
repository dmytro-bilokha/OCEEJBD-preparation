package com.dmytrobilokha.security.web;

import com.dmytrobilokha.security.ejb.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/")
@ServletSecurity(@HttpConstraint(rolesAllowed = "qa_users"))
public class GreetingServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServlet.class);

    @Inject
    private GreetingService greetingService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("GreetingServlet doGet called");
        PrintWriter output = resp.getWriter();
        output.print("<html><body>");
        output.print("<p>");
        output.print(greetingService.createCommonGreeting());
        output.print("</p>");
        output.print("<p>");
        output.print(greetingService.createGreeting());
        output.print("</p>");
        output.print("</body></html>");
    }

}

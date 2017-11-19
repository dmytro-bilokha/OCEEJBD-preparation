package com.dmytrobilokha.interceptor.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class GreetingServiceInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServiceInterceptor.class);

    @AroundInvoke
    Object logInvocation(InvocationContext invocationContext) throws Exception {
        LOGGER.info("Interceptor called before {} method", invocationContext.getMethod().getName());
        return invocationContext.proceed();
    }

}

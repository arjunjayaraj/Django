package com.qburst.spark.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;



/**
 * @author Arjun k
 * @since 29-Jul-2015 2015 3:01:00 pm
 * @version 
 * MyAuthenticationEntryPoint.java
 */

public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
	
}

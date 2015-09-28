package com.qburst.spark.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 * @author Arjun k
 * @since 29-Jul-2015 2015 3:04:44 pm
 * @version MyAuthenticationSuccessHandler.java
 */
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// This is actually not an error, but an OK message. It is sent to avoid
		// redirects.

		response.sendError(HttpServletResponse.SC_OK);
	}
}

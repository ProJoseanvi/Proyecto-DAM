package com.doctorplus.security;

import java.io.IOException;

import org.springframework.security.web.RedirectStrategy;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NoRedirectStrategy implements RedirectStrategy {

	@Override
	public void sendRedirect(final HttpServletRequest request, final HttpServletResponse response, final String url)
			throws IOException {
		// No redirect is required with pure REST
	}

}

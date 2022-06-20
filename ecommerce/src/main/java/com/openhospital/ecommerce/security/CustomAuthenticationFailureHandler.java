package com.openhospital.ecommerce.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        String errorMessage = "loginError";

        String targetUrl = httpServletRequest.getParameter("redirectUrl");

        if (targetUrl == null || targetUrl.isEmpty()) {
            targetUrl = "/";
        }

        log.info(">>> authentication error. targetUrl: " + targetUrl);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(targetUrl);

        if (!targetUrl.contains(errorMessage)) {
            stringBuilder.append(targetUrl.contains("?") ? "&" : "?");
            stringBuilder.append(errorMessage);
        }

        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, stringBuilder.toString());
    }

}

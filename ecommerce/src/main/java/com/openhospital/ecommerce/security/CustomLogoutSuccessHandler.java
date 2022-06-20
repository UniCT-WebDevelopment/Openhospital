package com.openhospital.ecommerce.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        String targetUrl = httpServletRequest.getParameter("redirectUrl");

        log.info(">>> logout success. targetUrl: " + targetUrl);
        if (targetUrl == null || targetUrl.isEmpty()) {
            targetUrl = "/";
        }

        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, targetUrl);
    }

}

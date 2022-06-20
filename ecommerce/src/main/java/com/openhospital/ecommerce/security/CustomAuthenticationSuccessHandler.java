package com.openhospital.ecommerce.security;

import com.openhospital.ecommerce.beans.user.UserProfile;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @SneakyThrows
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        String targetUrl = httpServletRequest.getParameter("redirectUrl");

        log.info(">>> authentication success. targetUrl: " + targetUrl);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info(">>> auth: " + auth);

        UserProfile user = null;

        if (auth != null && !(auth instanceof AnonymousAuthenticationToken) && auth.getPrincipal() != null) {
            log.debug("auth != null");
            user = (UserProfile) auth.getPrincipal();
            httpServletRequest.getSession().setAttribute("user", user);
        }

        if (targetUrl == null || targetUrl.isEmpty()) {
            targetUrl = "/";
        }
        if (targetUrl.contains("&loginError")) {
            targetUrl = targetUrl.replace("&loginError", "");
        }
        if (targetUrl.contains("/error")) {
            targetUrl = "/" + httpServletRequest.getLocale().getLanguage() + "/index";
        }

        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, targetUrl);
    }

}

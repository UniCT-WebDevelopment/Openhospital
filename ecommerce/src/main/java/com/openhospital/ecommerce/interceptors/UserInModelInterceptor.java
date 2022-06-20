package com.openhospital.ecommerce.interceptors;

import com.openhospital.ecommerce.beans.user.UserProfile;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class UserInModelInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        log.info(">>> START Interceptor: postHandle method");

        if (modelAndView != null) {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            log.info(">>> auth: " + auth);

            if (auth != null && !(auth instanceof AnonymousAuthenticationToken) && auth.getPrincipal() != null) {
                log.debug("auth != null");
                UserProfile user = (UserProfile) auth.getPrincipal();

                modelAndView.addObject("profile", user);
                log.debug("user: " + user.toString());
            }
        }

        log.info("<<< END Interceptor: postHandle method");
    }

    @Override
    public void afterCompletion(HttpServletRequest aRequest, HttpServletResponse aResponse, Object aHandler, Exception aEx) throws Exception {
    }

}

package com.openhospital.ecommerce.services;

import com.openhospital.ecommerce.beans.utils.AlternateUrl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Log4j2
@Service
public class UtilsService {

    public void addAlternateUrlsToModel(HttpServletRequest request, ModelAndView model, String page) {
        String url = request.getRequestURL().toString();
        String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
        String originalQueryString = request.getQueryString();
        String queryString = (originalQueryString == null) ? "" : "?"+originalQueryString;
        //log.info(queryString);

        ArrayList<AlternateUrl> alternateUrls = new ArrayList<>();

        AlternateUrl itaAlternateUrl = new AlternateUrl(baseURL + "it/" + page + queryString, "it");
        AlternateUrl engAlternateUrl = new AlternateUrl(baseURL + "en/" + page + queryString, "en");
        alternateUrls.add(itaAlternateUrl);
        alternateUrls.add(engAlternateUrl);

        model.addObject("alternateUrls", alternateUrls);
    }

    public void addRequestPathToModel(HttpServletRequest request, String lang, ModelAndView model, String page) {
        String originalQueryString = request.getQueryString();
        String queryString = (originalQueryString == null) ? "" : "?"+originalQueryString;
        log.info(queryString);

        String requestPath = "/" + lang + "/" + page + queryString;
        log.info(requestPath);

        model.addObject("requestPath", requestPath);
    }

}

package com.openhospital.ecommerce.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openhospital.ecommerce.beans.externalservices.newsservice.get.GetNewsInput;
import com.openhospital.ecommerce.beans.externalservices.newsservice.get.GetNewsOutput;
import com.openhospital.ecommerce.beans.externalservices.newsservice.get.News;
import com.openhospital.ecommerce.beans.externalservices.newsservice.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Log4j2
@Service
@PropertySource("${environment.properties}")
public class NewsService {

    @Value("${news-service.get-news.endpoint}")
    private String getNewsUrl;

    @Autowired
    RestTemplate restTemplate;

    public GetNewsOutput getNews(GetNewsInput getNewsInput) {

        GetNewsOutput getNewsOutput = new GetNewsOutput();
        log.info("requestObj: " + getNewsInput);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GetNewsInput> request = new HttpEntity<GetNewsInput>(getNewsInput, headers);
        try {
            getNewsOutput = restTemplate.postForObject(getNewsUrl, request, GetNewsOutput.class);
        } catch (HttpServerErrorException errorException) {
            log.error("non-blocking HttpServerErrorException: ", errorException);

            String responseBody = errorException.getResponseBodyAsString();

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                getNewsOutput = objectMapper.readValue(responseBody, GetNewsOutput.class);
            } catch (JsonMappingException e) {
                log.error("JsonMappingException: ", e);
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                log.error("JsonProcessingException: ", e);
                e.printStackTrace();
            }

        } catch (Exception e) {
            log.error("Error in News-Service response", e);
        }

        if (getNewsOutput != null) {
            log.info(">>> News-Service Response for getNewsOutput: [" + getNewsOutput + "]");
        } else {
            log.warn("News-Service Response IS NULL");
        }

        return getNewsOutput;
    }

    public ArrayList<News> searchNewsAndAddToModel(String lang, ModelAndView model) throws IOException {
        GetNewsInput getNewsInput = new GetNewsInput();
        getNewsInput.setLang(lang);

        GetNewsOutput getNewsOutput = getNews(getNewsInput);

        Result result = getNewsOutput.getResult();
        ArrayList<News> newsList = null;

        if (result != null && result.getValidResponse()) {
            log.error("News-Service Response is valid");
            ArrayList<News> originalNewsList = (ArrayList<News>) getNewsOutput.getNews();
            newsList = (ArrayList<News>) originalNewsList.stream().limit(3).collect(Collectors.toList());
            model.addObject("newsList", newsList);
        } else {
            log.error("News-Service Response is not valid. Setting an error message to be shown.");
            if (result != null)
                model.addObject("errorMessage", "errorCodeMsg." + result.getCode());
            else
                model.addObject("errorMessage", "errorCodeMsg.001");
        }

        return newsList;
    }
}

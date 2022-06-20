package com.openhospital.ecommerce.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.get.GetProposalsInput;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.get.GetProposalsOutput;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.lock.LockProposalsInput;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.lock.LockProposalsOutput;
import com.openhospital.ecommerce.beans.externalservices.productservice.reservation.buy.BuyReservationsInput;
import com.openhospital.ecommerce.beans.externalservices.productservice.reservation.buy.BuyReservationsOutput;
import com.openhospital.ecommerce.beans.externalservices.productservice.ward.GetWardsInput;
import com.openhospital.ecommerce.beans.externalservices.productservice.ward.GetWardsOutput;
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

@Log4j2
@Service
@PropertySource("${environment.properties}")
public class ProductService {

    @Value("${product-service.get-wards.endpoint}")
    private String getWardsUrl;

    @Value("${product-service.get-proposals.endpoint}")
    private String getProposalsUrl;

    @Value("${product-service.lock-proposals.endpoint}")
    private String lockProposalsUrl;

    @Value("${product-service.buy-proposals.endpoint}")
    private String buyReservationUrl;

    @Autowired
    RestTemplate restTemplate;

    public GetProposalsOutput getProposals(GetProposalsInput requestObj) {

        GetProposalsOutput getProposalsOutput = new GetProposalsOutput();
        log.info("requestObj: " + requestObj);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GetProposalsInput> request = new HttpEntity<GetProposalsInput>(requestObj, headers);
        try {
            getProposalsOutput = restTemplate.postForObject(getProposalsUrl, request, GetProposalsOutput.class);
        } catch (HttpServerErrorException errorException) {
            log.error("non-blocking HttpServerErrorException: ", errorException);

            String responseBody = errorException.getResponseBodyAsString();

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                getProposalsOutput = objectMapper.readValue(responseBody, GetProposalsOutput.class);
            } catch (JsonMappingException e) {
                log.error("JsonMappingException: ", e);
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                log.error("JsonProcessingException: ", e);
                e.printStackTrace();
            }

        } catch (Exception e) {
            log.error("Error in Product-Service response", e);
        }

        if (getProposalsOutput != null) {
            log.info(">>> Product-Service Response for GetProposalsOutput: [" + getProposalsOutput + "]");
        } else {
            log.warn("Product-Service Response IS NULL");
        }

        return getProposalsOutput;
    }

    public LockProposalsOutput lockProposals(LockProposalsInput requestObj) {

        LockProposalsOutput lockProposalsOutput = new LockProposalsOutput();
        log.info("requestObj: " + requestObj);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LockProposalsInput> request = new HttpEntity<LockProposalsInput>(requestObj, headers);
        try {
            lockProposalsOutput = restTemplate.postForObject(lockProposalsUrl, request, LockProposalsOutput.class);
        } catch (HttpServerErrorException errorException) {
            log.error("non-blocking HttpServerErrorException: ", errorException);

            String responseBody = errorException.getResponseBodyAsString();

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                lockProposalsOutput = objectMapper.readValue(responseBody, LockProposalsOutput.class);
            } catch (JsonMappingException e) {
                log.error("JsonMappingException: ", e);
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                log.error("JsonProcessingException: ", e);
                e.printStackTrace();
            }

        } catch (Exception e) {
            log.error("Error in Product-Service response", e);
        }

        if (lockProposalsOutput != null) {
            log.info(">>> Product-Service Response for LockProposalsOutput: [" + lockProposalsOutput + "]");
        } else {
            log.warn("Product-Service Response IS NULL");
        }

        return lockProposalsOutput;
    }

    public BuyReservationsOutput buyReservations(BuyReservationsInput reservationsRequestObj) {

        BuyReservationsOutput buyReservationsOutput = new BuyReservationsOutput();
        log.info("requestObj: " + reservationsRequestObj);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<BuyReservationsInput> request = new HttpEntity<BuyReservationsInput>(reservationsRequestObj, headers);
        try {
            buyReservationsOutput = restTemplate.postForObject(buyReservationUrl, request, BuyReservationsOutput.class);
        } catch (HttpServerErrorException errorException) {
            log.error("non-blocking HttpServerErrorException: ", errorException);

            String responseBody = errorException.getResponseBodyAsString();

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                buyReservationsOutput = objectMapper.readValue(responseBody, BuyReservationsOutput.class);
            } catch (JsonMappingException e) {
                log.error("JsonMappingException: ", e);
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                log.error("JsonProcessingException: ", e);
                e.printStackTrace();
            }

        } catch (Exception e) {
            log.error("Error in Product-Service response", e);
        }

        if (buyReservationsOutput != null) {
            log.info(">>> Product-Service Response for LockProposalsOutput: [" + buyReservationsOutput + "]");
        } else {
            log.warn("Product-Service Response IS NULL");
        }

        return buyReservationsOutput;
    }

    public GetWardsOutput getWards(GetWardsInput wardsRequestObj) {

        GetWardsOutput wardsOutput = new GetWardsOutput();
        log.info("requestObj: " + wardsRequestObj);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GetWardsInput> request = new HttpEntity<GetWardsInput>(wardsRequestObj, headers);
        try {
            wardsOutput = restTemplate.postForObject(getWardsUrl, request, GetWardsOutput.class);
        } catch (HttpServerErrorException errorException) {
            log.error("non-blocking HttpServerErrorException: ", errorException);

            String responseBody = errorException.getResponseBodyAsString();

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                wardsOutput = objectMapper.readValue(responseBody, GetWardsOutput.class);
            } catch (JsonMappingException e) {
                log.error("JsonMappingException: ", e);
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                log.error("JsonProcessingException: ", e);
                e.printStackTrace();
            }

        } catch (Exception e) {
            log.error("Error in Product-Service response", e);
        }

        if (wardsOutput != null) {
            log.info(">>> Product-Service Response for GetWardsOutput: [" + wardsOutput + "]");
        } else {
            log.warn("Product-Service Response IS NULL");
        }

        return wardsOutput;
    }

}

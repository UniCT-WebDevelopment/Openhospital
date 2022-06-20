package com.openhospital.ecommerce.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openhospital.ecommerce.beans.externalservices.userservice.add.AddUserInput;
import com.openhospital.ecommerce.beans.externalservices.userservice.add.AddUserOutput;
import com.openhospital.ecommerce.beans.externalservices.userservice.edit.EditUserInput;
import com.openhospital.ecommerce.beans.externalservices.userservice.edit.EditUserOutput;
import com.openhospital.ecommerce.beans.externalservices.userservice.get.GetUserInput;
import com.openhospital.ecommerce.beans.externalservices.userservice.get.GetUserOutput;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
@PropertySource("${environment.properties}")
public class UserService {

    @Value("${user-service.get-user.endpoint}")
    private String getUserUrl;

    @Value("${user-service.add-user.endpoint}")
    private String addUserUrl;

    @Value("${user-service.edit-user.endpoint}")
    private String editUserUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public GetUserOutput getUser(GetUserInput getUserInput) {

        GetUserOutput getUserOutput = new GetUserOutput();
        log.info("requestObj: " + getUserInput);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GetUserInput> request = new HttpEntity<GetUserInput>(getUserInput, headers);
        try {
            getUserOutput = restTemplate.postForObject(getUserUrl, request, GetUserOutput.class);
        } catch (HttpServerErrorException errorException) {
            log.error("non-blocking HttpServerErrorException: ", errorException);

            String responseBody = errorException.getResponseBodyAsString();

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                getUserOutput = objectMapper.readValue(responseBody, GetUserOutput.class);
            } catch (JsonMappingException e) {
                log.error("JsonMappingException: ", e);
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                log.error("JsonProcessingException: ", e);
                e.printStackTrace();
            }

        } catch (Exception e) {
            log.error("Error in User-Service response", e);
        }

        if (getUserOutput != null) {
            log.info(">>> User-Service Response for GetUserOutput: [" + getUserOutput + "]");
        } else {
            log.warn("User-Service Response IS NULL");
        }

        return getUserOutput;
    }

    public AddUserOutput addUser(AddUserInput addUserInput) {

        AddUserOutput addUserOutput = new AddUserOutput();
        addUserInput.setPassword(passwordEncoder.encode(addUserInput.getPassword()));
        log.info("requestObj: " + addUserInput);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AddUserInput> request = new HttpEntity<AddUserInput>(addUserInput, headers);
        try {
            addUserOutput = restTemplate.postForObject(addUserUrl, request, AddUserOutput.class);
        } catch (HttpServerErrorException errorException) {
            log.error("non-blocking HttpServerErrorException: ", errorException);

            String responseBody = errorException.getResponseBodyAsString();

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                addUserOutput = objectMapper.readValue(responseBody, AddUserOutput.class);
            } catch (JsonMappingException e) {
                log.error("JsonMappingException: ", e);
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                log.error("JsonProcessingException: ", e);
                e.printStackTrace();
            }

        } catch (Exception e) {
            log.error("Error in User-Service response", e);
        }

        if (addUserOutput != null) {
            log.info(">>> User-Service Response for AddUserOutput: [" + addUserOutput + "]");
        } else {
            log.warn("User-Service Response IS NULL");
        }

        return addUserOutput;
    }

    public EditUserOutput editUser(EditUserInput editUserInput) {

        EditUserOutput editUserOutput = new EditUserOutput();
        editUserInput.setPassword(passwordEncoder.encode(editUserInput.getPassword()));
        log.info("requestObj: " + editUserInput);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<EditUserInput> request = new HttpEntity<EditUserInput>(editUserInput, headers);
        try {
            editUserOutput = restTemplate.postForObject(editUserUrl, request, EditUserOutput.class);
        } catch (HttpServerErrorException errorException) {
            log.error("non-blocking HttpServerErrorException: ", errorException);

            String responseBody = errorException.getResponseBodyAsString();

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                editUserOutput = objectMapper.readValue(responseBody, EditUserOutput.class);
            } catch (JsonMappingException e) {
                log.error("JsonMappingException: ", e);
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                log.error("JsonProcessingException: ", e);
                e.printStackTrace();
            }

        } catch (Exception e) {
            log.error("Error in User-Service response", e);
        }

        if (editUserOutput != null) {
            log.info(">>> User-Service Response for EditUserOutput: [" + editUserOutput + "]");
        } else {
            log.warn("User-Service Response IS NULL");
        }

        return editUserOutput;
    }

}
